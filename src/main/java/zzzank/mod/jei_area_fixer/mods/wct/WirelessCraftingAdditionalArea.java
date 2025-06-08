package zzzank.mod.jei_area_fixer.mods.wct;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.wct.client.gui.GuiWCT;
import p455w0rd.wct.client.gui.widgets.GuiImgButtonMagnetMode;
import p455w0rd.wct.client.gui.widgets.GuiImgButtonShiftCraft;
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
    public static final ButtonIndex<GuiButton> BUTTON_INDEX = ButtonIndex.register((b) ->
        b instanceof GuiImgButtonMagnetMode ||
        b instanceof GuiImgButtonShiftCraft
    );

    @Override
    protected ButtonIndex<GuiButton> getButtonIndex() {
        return BUTTON_INDEX;
    }

    @Nonnull
    @Override
    protected Class<GuiWCT> getTarget() {
        return GuiWCT.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiButton> buttons, @Nonnull GuiWCT gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible && AreaFilter.notShiftingBookmarkAE(button)) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
