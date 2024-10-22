package zzzank.mod.jei_area_fixer.datagen;

import lombok.val;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.Tags;
import zzzank.mod.jei_area_fixer.utils.NameUtils;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;

/**
 * langKey: modid + "." + (category.isEmpty() ? "" : category+".") + f.getName().toLowerCase(Locale.ENGLISH);
 * tooltop langKey: langKey + ".tooltip"
 * @author ZZZank
 */
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class ConfigClassScanner {

    public static final boolean ENABLE_SCAN = true;

    static void scan(@Nonnull Config anno, @Nonnull Class<?> clazz) {
        val prefix = anno.modid() + "." + (anno.category().isEmpty() ? "" : anno.category() + ".");
        try {
            scanImpl(clazz, null, prefix);
        } catch (IllegalAccessException e) {
        }
    }

    static void print(String key, Field field) {
        JEIAreaFixer.LOGGER.info(
            "{}={}",
            key,
            NameUtils.titleToSplitTitle(
                Modifier.isFinal(field.getModifiers())
                    ? field.getName().toLowerCase(Locale.ROOT)
                    : field.getName()
            )
        );
        JEIAreaFixer.LOGGER.info(
            "{}.tooltip={}",
            key,
            field.isAnnotationPresent(Config.Comment.class)
                ? field.getAnnotation(Config.Comment.class).value()
                : "Unresolved"
        );
    }

    static void scanImpl(Class<?> clazz, Object instance, String prefix) throws IllegalAccessException {
        for (val field : clazz.getFields()) {
            val modifiers = field.getModifiers();
            if (!Modifier.isPublic(modifiers)
                || Modifier.isStatic(modifiers) != (instance == null)
            ) {
                continue;
            }
            val sub = prefix + field.getName().toLowerCase(Locale.ROOT);
            print(sub, field);
            val type = field.getType();
            if (type.getSimpleName().startsWith("_")) {
                scanImpl(type, field.get(instance), sub + ".");
            }
        }
    }

    @SubscribeEvent
    public static void captureCategoryLangkeys(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer) || !event.getWorld().isRemote) {
            return;
        }
        if (ENABLE_SCAN) {
            scan(JEIAreaFixerConfig.class.getAnnotation(Config.class), JEIAreaFixerConfig.class);
        }
    }
}
