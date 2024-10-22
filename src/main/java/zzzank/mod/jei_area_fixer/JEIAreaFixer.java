package zzzank.mod.jei_area_fixer;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
@Mod(
    modid = Tags.MOD_ID,
    name = Tags.MOD_NAME,
    version = Tags.VERSION,
    dependencies = "after:jei@[4.16.0,);required-after:mixinbooter;",
    clientSideOnly = true
)
@Mod.EventBusSubscriber(Side.CLIENT)
public class JEIAreaFixer {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_ID);

    /**
     * @return null if provided null, otherwise a singleton list
     */
    @Nullable
    public static List<Rectangle> nullableWrap(@Nullable Rectangle rectangle) {
        return rectangle == null ? null : Collections.singletonList(rectangle);
    }

    public static Rectangle rectFromButton(@Nonnull GuiButton button) {
        return new Rectangle(button.x, button.y, button.width, button.height);
    }

    public static <T> Class<T> cast(Class c) {
        return c;
    }

    /**
     * @see GuiScreen#initGui() javadoc of initGui(), where it mentions that buttonList will be rebuilt on windows resize
     */
    @SubscribeEvent
    public static void rebuildCacheOnResize(GuiScreenEvent.InitGuiEvent event) {
        val gui = event.getGui();
        if (!(gui instanceof GuiContainer)) {
            return;
        }
        ((ButtonsCacheHolder) gui).jaf$getCache().clear();
    }

    /*
    @SubscribeEvent
    public static void captureCategoryLangkeys(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            Configuration config;
            try {
                val f = ConfigManager.class.getDeclaredMethod("getConfiguration", String.class, String.class);
                f.setAccessible(true);
                config = ((Configuration) f.invoke(null, Tags.MOD_ID, Tags.MOD_ID));
            } catch (Exception e) {
                LOGGER.error(e);
                return;
            }
            if (config == null) {
                LOGGER.error("config for {} not found", Tags.MOD_ID);
                return;
            }
            for (String categoryName : config.getCategoryNames()) {
                val category = config.getCategory(categoryName);
                System.out.println(category.getLanguagekey());
            }
        }
    }
     */
}
