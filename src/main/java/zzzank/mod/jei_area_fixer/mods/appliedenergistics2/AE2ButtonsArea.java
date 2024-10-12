package zzzank.mod.jei_area_fixer.mods.appliedenergistics2;

import appeng.client.gui.AEBaseGui;
import appeng.client.gui.widgets.GuiImgButton;
import appeng.client.gui.widgets.GuiTabButton;
import appeng.client.gui.widgets.GuiToggleButton;
import net.minecraft.client.gui.GuiButton;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheIndex;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * buttons in storage bus / input bus / output bus / terminal / ...
 *
 * @author ZZZank
 */
public class AE2ButtonsArea extends AbstractJEIAreaProvider<AEBaseGui> {
    public AE2ButtonsArea() {
        super(AEBaseGui.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull AEBaseGui gui) {
        var access = ((ButtonsCacheHolder) gui);

        var cache = access
            .jeiAreaFixer$getCache()
            .computeIfAbsent(ButtonsCacheIndex.AE2, k -> createButtonsCache(access));

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var button : cache) {
            areas.add(JEIAreaFixer.rectFromButton(button));
        }
        return areas;
    }

    /**
     * @see mezz.jei.gui.overlay.IngredientGridWithNavigation#updateBounds(Rectangle, Set, int) IngredientGridWithNavigation for the reason of `20`
     */
    private static List<GuiButton> createButtonsCache(ButtonsCacheHolder access) {
        List<GuiButton> list = new ArrayList<>();
        for (var b : access.jeiAreaFixer$getButtonList()) {
            if ((b instanceof GuiImgButton || b instanceof GuiTabButton || b instanceof GuiToggleButton)
                && b.visible
                && (!JEIAreaFixerConfig.AE2$IgnoreAreasTooHigh || b.y > 20)
            ) {
                list.add(b);
            }
        }
        return list;
    }
}
