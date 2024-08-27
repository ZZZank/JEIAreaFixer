package zzzank.mod.jei_area_fixer.mixin.minecraft;

import codersafterdark.reskillable.base.ConfigHandler;
import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.reskillable.ReskillableAreasProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ZZZank
 */
@Mixin(GuiContainer.class)
public abstract class MixinGuiContainerForReskillable extends GuiScreen implements ReskillableAreasProvider {

    /**
     * there are currently at most 3 buttons
     */
    @Unique
    private final List<GuiButtonInventoryTab> jeiAreaFixer$reskillableButtons = new ArrayList<>(3 + 1);

    @Override
    public List<Rectangle> jei_area_fixer$getReskillableAreas() {
        if (!ConfigHandler.enableTabs || !ModState.RESKILLABLE) {
            return Collections.emptyList();
        }
        if (this.jeiAreaFixer$reskillableButtons.isEmpty()) {
            for (GuiButton b : this.buttonList) {
                if (b instanceof GuiButtonInventoryTab button) {
                    jeiAreaFixer$reskillableButtons.add(button);
                }
            }
        }
        var areas = new ArrayList<Rectangle>(jeiAreaFixer$reskillableButtons.size());
        for (var reskillableButton : jeiAreaFixer$reskillableButtons) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
