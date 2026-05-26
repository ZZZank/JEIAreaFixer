package zzzank.mod.jei_area_fixer.mods.minecraft;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class AggressiveButtonArea extends GeneralButtonsAreaProvider<GuiButton> {
    private static final ButtonIndex<GuiButton> BUTTON_INDEX
        = ButtonIndex.register(ignored -> true);

    @Override
    protected ButtonIndex<GuiButton> getButtonIndex() {
        return BUTTON_INDEX;
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull GuiContainer gui) {
        val bounds = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible || button.enabled) { // not a good idea, but SOME mod devs are not using these two options correctly
                bounds.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return bounds;
    }
}
