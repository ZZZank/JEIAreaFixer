package zzzank.mod.jei_area_fixer.mods.mctsmelteryio;

import mctmods.smelteryio.tileentity.gui.GuiCM;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZZZank
 */
public class CastingMachineArea extends AbstractJEIAreaProvider<GuiCM> {

    public CastingMachineArea() {
        super(GuiCM.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiCM gui) {
        //this.buttonEmptyTank = new GuiButton(0, this.guiLeft - 20, this.guiTop + this.ySize - 166, 20, 20, "") {
        //this.buttonLockSlots = new GuiButton(1, this.guiLeft - 20, this.guiTop + this.ySize - 146, 20, 20, "") {
        return Arrays.asList(
            new Rectangle(gui.getGuiLeft() - 20, gui.getGuiTop() + gui.getYSize() - GuiCM.HEIGHT, 20, 20),
            new Rectangle(gui.getGuiLeft() - 20, gui.getGuiTop() + gui.getYSize() - GuiCM.HEIGHT - 20, 20, 20)
        );
    }
}