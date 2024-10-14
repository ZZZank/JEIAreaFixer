package zzzank.mod.jei_area_fixer.mods.trinkets_and_baubles;

import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import xzeroair.trinkets.client.gui.TrinketGuiButton;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * we have to use {@link GeneralButtonsAreaProvider} here because it's targeting more than one GUI type
 * @see xzeroair.trinkets.client.events.GuiScreenEvents#guiPostInit(GuiScreenEvent.InitGuiEvent.Post)
 * @author ZZZank
 */
public class TrinketGuiButtonArea extends GeneralButtonsAreaProvider<TrinketGuiButton> {
    public TrinketGuiButtonArea() {
        super(ButtonIndex.TRINKET);
    }

    /**
     * @see TrinketGuiButton#drawButton(Minecraft, int, int, float)
     */
    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(
        @Nonnull List<TrinketGuiButton> buttons,
        @Nonnull GuiContainer gui
    ) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val b : buttons) {
            val area = ModState.BAUBLES && b.id == 55
                ? new Rectangle(b.x + gui.getGuiLeft(), b.y, 10, 10)
                : new Rectangle(b.x + gui.getGuiLeft(), b.y, b.width, b.height);
            areas.add(area);
        }
        return areas;
    }
}
