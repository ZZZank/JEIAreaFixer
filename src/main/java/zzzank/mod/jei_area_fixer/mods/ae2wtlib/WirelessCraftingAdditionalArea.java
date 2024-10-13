package zzzank.mod.jei_area_fixer.mods.ae2wtlib;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.wct.client.gui.GuiWCT;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class WirelessCraftingAdditionalArea extends ButtonsAreaProvider<GuiButton, GuiWCT> {
    public WirelessCraftingAdditionalArea() {
        super(ButtonIndex.WIRELESS_CRAFTING_TERMINAL, GuiWCT.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull GuiWCT gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible && AreaFilter.notShiftingBookmark(button)) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
