package zzzank.mod.jei_area_fixer.mods.appliedenergistics2;

import appeng.client.gui.AEBaseGui;
import appeng.client.gui.widgets.GuiImgButton;
import appeng.client.gui.widgets.GuiTabButton;
import appeng.client.gui.widgets.GuiToggleButton;
import net.minecraft.client.gui.GuiButton;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheIndexes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

        var cache = access.jeiAreaFixer$getCache()
            .computeIfAbsent(
                ButtonsCacheIndexes.AE2,
                k -> {
                    List<GuiButton> list = new ArrayList<>();
                    for (var b : access.jeiAreaFixer$getButtonList()) {
                        if (b instanceof GuiImgButton || b instanceof GuiTabButton || b instanceof GuiToggleButton) {
                            list.add(b);
                        }
                    }
                    return list;
                }
            );

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var button : cache) {
            areas.add(JEIAreaFixer.rectFromButton(button));
        }
        return areas;
    }
}