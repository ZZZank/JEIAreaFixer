package zzzank.mod.jei_area_fixer.mods.xat;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import xzeroair.trinkets.client.gui.TrinketGuiButton;
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
public class TrinketGuiButtonArea extends ButtonsAreaProvider<TrinketGuiButton> {
    public TrinketGuiButtonArea() {
        super(ButtonIndex.TRINKET);
    }

    /**
     * @see TrinketGuiButton#drawButton(Minecraft, int, int, float)
     */
    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(
        @Nonnull ImmutableList<TrinketGuiButton> buttons,
        @Nonnull GuiContainer gui
    ) {
        var areas = new ArrayList<Rectangle>(buttons.size());
        for (var b : buttons) {
            var area = new Rectangle(b.x + gui.getGuiLeft(), b.y, b.width, b.height);
            areas.add(area);
        }
        return areas;
    }
}
