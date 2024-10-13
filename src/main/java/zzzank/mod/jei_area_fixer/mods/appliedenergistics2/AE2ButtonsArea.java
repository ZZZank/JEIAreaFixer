package zzzank.mod.jei_area_fixer.mods.appliedenergistics2;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;

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
public class AE2ButtonsArea extends GeneralButtonsAreaProvider<GuiButton> {
    public AE2ButtonsArea() {
        super(ButtonIndex.AE2);
    }

    /**
     * @see mezz.jei.gui.overlay.IngredientGridWithNavigation#updateBounds(Rectangle, Set, int) IngredientGridWithNavigation for the reason of `20`
     */
    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull GuiContainer gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible && !(!JEIAreaFixerConfig.AE2$IgnoreAreasTooHigh || button.y > 20)) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
