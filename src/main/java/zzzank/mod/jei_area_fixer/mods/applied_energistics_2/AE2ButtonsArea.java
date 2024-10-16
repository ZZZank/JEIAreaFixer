package zzzank.mod.jei_area_fixer.mods.applied_energistics_2;

import appeng.client.gui.AEBaseGui;
import lombok.val;
import net.minecraft.client.gui.GuiButton;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

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
public class AE2ButtonsArea extends ButtonsAreaProvider<GuiButton, AEBaseGui> {
    public AE2ButtonsArea() {
        super(ButtonIndex.AE2, AEBaseGui.class);
    }

    /**
     * @see mezz.jei.gui.overlay.IngredientGridWithNavigation#updateBounds(Rectangle, Set, int) IngredientGridWithNavigation for the reason of `20`
     */
    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull AEBaseGui gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible && AreaFilter.notShiftingBookmarkAE(button)) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
