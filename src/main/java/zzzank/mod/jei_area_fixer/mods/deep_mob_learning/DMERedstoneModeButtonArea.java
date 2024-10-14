package zzzank.mod.jei_area_fixer.mods.deep_mob_learning;

import lombok.val;
import mustapelto.deepmoblearning.client.gui.GuiMachine;
import mustapelto.deepmoblearning.client.gui.buttons.ButtonRedstoneMode;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class DMERedstoneModeButtonArea extends ButtonsAreaProvider<ButtonRedstoneMode, GuiMachine> {
    public DMERedstoneModeButtonArea() {
        super(ButtonIndex.DME_REDSTONE, GuiMachine.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<ButtonRedstoneMode> buttons, @Nonnull GuiMachine gui) {
        if (buttons.size() == 1) {
            return Collections.singletonList(JEIAreaFixer.rectFromButton(buttons.get(0)));
        }
        val areas = new ArrayList<Rectangle>();
        for (val button : buttons) {
            areas.add(JEIAreaFixer.rectFromButton(button));
        }
        return areas;
    }
}
