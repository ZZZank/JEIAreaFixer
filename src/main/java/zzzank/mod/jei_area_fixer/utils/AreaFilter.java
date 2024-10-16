package zzzank.mod.jei_area_fixer.utils;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;

import javax.annotation.Nonnull;

/**
 * some filter presets
 * @author ZZZank
 */
public interface AreaFilter {
    int JEI_BOOKMARK_TOP_HEIGHT = 20;

    static boolean notShiftingBookmarkAE(@Nonnull GuiButton button) {
        return !JEIAreaFixerConfig.AE2.preventShiftingBookmark || notShiftingBookmark(button);
    }

    static boolean notShiftingBookmark(@Nonnull GuiButton button) {
        return button.y > JEI_BOOKMARK_TOP_HEIGHT;
    }

    static boolean notInGui(@Nonnull GuiContainer gui, @Nonnull GuiButton button) {
        return button.x < gui.getGuiLeft() || button.x + button.width > gui.getGuiLeft() + gui.getXSize();
    }
}
