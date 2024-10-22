package zzzank.mod.jei_area_fixer.datagen;

import lombok.val;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.Tags;

import javax.annotation.Nonnull;
import java.lang.reflect.Modifier;
import java.util.Locale;

/**
 * @author ZZZank
 */
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public final class ConfigClassScanner {

    public static final boolean ENABLED_OLD = false;
    public static final boolean ENABLED_SCAN = true;

    static void scan(@Nonnull Config anno, @Nonnull Class<?> clazz) {
        val prefix = anno.modid() + "." + (anno.category().isEmpty() ? "" : anno.category() + ".");
        try {
            scanImpl(clazz, null, prefix);
        } catch (IllegalAccessException e) {
        }
    }

    static void print(String name) {
        JEIAreaFixer.LOGGER.info("{}=Unresolved", name);
        JEIAreaFixer.LOGGER.info("{}.tooltip=Unresolved(Tooltips)", name);
    }

    static void scanImpl(Class<?> clazz, Object instance, String prefix) throws IllegalAccessException {
        for (val field : clazz.getFields()) {
            val modifiers = field.getModifiers();
            if (!Modifier.isPublic(modifiers)
                || Modifier.isStatic(modifiers) != (instance == null)
            ) {
                continue;
            }
            val type = field.getType();
            if (type.getSimpleName().startsWith("_")) {
                val sub = prefix + field.getName().toLowerCase(Locale.ROOT);
                print(sub);
                scanImpl(type, field.get(instance), sub + ".");
            } else {
                val sub = prefix + field.getName();
                print(sub);
            }
        }
    }

    @SubscribeEvent
    public static void captureCategoryLangkeys(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) {
            return;
        }
        if (ENABLED_SCAN) {
            scan(JEIAreaFixerConfig.class.getAnnotation(Config.class), JEIAreaFixerConfig.class);
        }
        if (ENABLED_OLD) {
            Configuration config;
            try {
                val f = ConfigManager.class.getDeclaredMethod("getConfiguration", String.class, String.class);
                f.setAccessible(true);
                config = ((Configuration) f.invoke(null, Tags.MOD_ID, Tags.MOD_ID));
            } catch (Exception e) {
                JEIAreaFixer.LOGGER.error(e);
                return;
            }
            if (config == null) {
                JEIAreaFixer.LOGGER.error("config for {} not found", Tags.MOD_ID);
                return;
            }
            for (val categoryName : config.getCategoryNames()) {
                val category = config.getCategory(categoryName);
                JEIAreaFixer.LOGGER.info(category.getLanguagekey());
            }
        }
    }
}
