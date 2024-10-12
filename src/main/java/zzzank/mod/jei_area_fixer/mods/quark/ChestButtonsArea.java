package zzzank.mod.jei_area_fixer.mods.quark;

import com.google.common.collect.ImmutableList;
import vazkii.quark.management.client.gui.GuiButtonChest;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class ChestButtonsArea extends ButtonsAreaProvider<GuiButtonChest> {

    public ChestButtonsArea() {
        super(ButtonIndex.QUARK);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull ImmutableList<GuiButtonChest> buttons) {
        var areas = new ArrayList<Rectangle>(buttons.size());
        for (var reskillableButton : buttons) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
