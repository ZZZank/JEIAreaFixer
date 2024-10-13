package zzzank.mod.jei_area_fixer.mods.quark;

import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import vazkii.quark.management.client.gui.GuiButtonChest;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * we have to use {@link GeneralButtonsAreaProvider} here because it's targeting more than one GUI type
 * @see vazkii.quark.management.feature.ChestButtons#initGui(GuiScreenEvent.InitGuiEvent.Post)
 * @author ZZZank
 */
public class ChestButtonsArea extends GeneralButtonsAreaProvider<GuiButtonChest> {

    public ChestButtonsArea() {
        super(ButtonIndex.QUARK);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButtonChest> buttons, @Nonnull GuiContainer gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val reskillableButton : buttons) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
