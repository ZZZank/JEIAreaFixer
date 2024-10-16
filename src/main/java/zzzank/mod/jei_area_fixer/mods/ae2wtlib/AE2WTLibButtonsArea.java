package zzzank.mod.jei_area_fixer.mods.ae2wtlib;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.ae2wtlib.api.client.gui.GuiWT;
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
public class AE2WTLibButtonsArea extends ButtonsAreaProvider<GuiButton, GuiWT> {
    public AE2WTLibButtonsArea() {
        super(ButtonIndex.AE2WT_LIB, GuiWT.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull GuiWT gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible && AreaFilter.notShiftingBookmarkAE(button)) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
