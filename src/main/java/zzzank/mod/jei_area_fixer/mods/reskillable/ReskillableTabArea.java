package zzzank.mod.jei_area_fixer.mods.reskillable;

import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see codersafterdark.reskillable.client.gui.handler.InventoryTabHandler#initGui(GuiScreenEvent.InitGuiEvent.Post)
 * @author ZZZank
 */
public class ReskillableTabArea extends GeneralButtonsAreaProvider<GuiButtonInventoryTab> {

    public ReskillableTabArea() {
        super(ButtonIndex.RESKILLABLE);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButtonInventoryTab> buttons, @Nonnull GuiContainer gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val reskillableButton : buttons) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
