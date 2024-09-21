package zzzank.mod.jei_area_fixer.mods.quark;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.inventory.GuiContainer;
import vazkii.quark.management.client.gui.GuiButtonChest;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheIndexes;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class ChestButtonsArea extends AbstractJEIAreaProvider<GuiContainer> {

    public ChestButtonsArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        var access = ((ButtonsCacheHolder) gui);

        var cache = access.jeiAreaFixer$computeCacheIfAbsent(
            ButtonsCacheIndexes.QUARK,
            GuiButtonChest.class
        );

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var reskillableButton : cache) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
