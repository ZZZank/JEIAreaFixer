package zzzank.mod.jei_area_fixer.mods.ae2wtlib;

import appeng.client.gui.widgets.GuiImgButton;
import appeng.client.gui.widgets.GuiToggleButton;
import lombok.val;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.ae2wtlib.api.client.gui.GuiWT;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiImgButtonBooster;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiItemIconButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTabButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTrashButton;
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
    public static final ButtonIndex<GuiButton> AE2WT_LIB = ButtonIndex.register((b) ->
        //from AE2WTLib
        b instanceof GuiImgButtonBooster ||
        b instanceof GuiTabButton ||
        b instanceof GuiTrashButton ||
        b instanceof GuiItemIconButton ||
        //from AE2, doing so because the target class, GUiWT, is not inherited from AE screen classes
        b instanceof GuiImgButton ||
        b instanceof GuiToggleButton
    );

    public AE2WTLibButtonsArea() {
        super(AE2WT_LIB);
    }

    @Nonnull
    @Override
    protected Class<GuiWT> getTarget() {
        return GuiWT.class;
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
