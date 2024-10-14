package zzzank.mod.jei_area_fixer.mods.deep_mob_learning;

import mustapelto.deepmoblearning.DMLConstants;
import mustapelto.deepmoblearning.client.gui.GuiSimulationChamber;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class SimulationChamberArea extends AbstractJEIAreaProvider<GuiSimulationChamber> {
    public SimulationChamberArea() {
        super(GuiSimulationChamber.class);
    }

    /**
     * @see GuiSimulationChamber#drawGuiContainerBackgroundLayer(float, int, int)
     */
    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiSimulationChamber gui) {
        //this.drawTexturedModalRect(this.guiLeft + DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.LEFT, this.guiTop + DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.TOP, GuiSimulationChamber.TextureCoords.DATA_MODEL_SLOT.X, GuiSimulationChamber.TextureCoords.DATA_MODEL_SLOT.Y, DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.WIDTH, DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.HEIGHT);
        return Collections.singletonList(new Rectangle(
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.LEFT + gui.getGuiLeft(),
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.TOP + gui.getGuiTop(),
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.WIDTH,
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.HEIGHT
        ));
    }
}
