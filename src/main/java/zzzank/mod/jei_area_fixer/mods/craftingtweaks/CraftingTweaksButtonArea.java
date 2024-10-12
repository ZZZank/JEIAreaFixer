package zzzank.mod.jei_area_fixer.mods.craftingtweaks;

import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheIndex;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class CraftingTweaksButtonArea extends AbstractJEIAreaProvider<GuiContainer> {
    public CraftingTweaksButtonArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        var access = ((ButtonsCacheHolder) gui);
        var buttons = access.jeiAreaFixer$computeCacheIfAbsent(
            ButtonsCacheIndex.CRAFTING_TWEAKS,
            GuiTweakButton.class
        );
        if (buttons.isEmpty()) {
            return null;
        }
        var areas = new ArrayList<Rectangle>();
        for (var button : buttons) {
            areas.add(JEIAreaFixer.rectFromButton(button));
        }
        return areas;
    }
}
