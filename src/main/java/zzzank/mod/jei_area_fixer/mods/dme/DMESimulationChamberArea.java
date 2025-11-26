package zzzank.mod.jei_area_fixer.mods.dme;

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
public class DMESimulationChamberArea extends AbstractJEIAreaProvider<GuiSimulationChamber> {

    @Nonnull
    @Override
    protected Class<GuiSimulationChamber> getTarget() {
        return GuiSimulationChamber.class;
    }

    /**
     * @see GuiSimulationChamber#drawGuiContainerBackgroundLayer(float, int, int)
     */
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiSimulationChamber gui) {
        //this.drawTexturedModalRect(this.guiLeft + DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.LEFT, this.guiTop + DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.TOP, GuiSimulationChamber.TextureCoords.DATA_MODEL_SLOT.X, GuiSimulationChamber.TextureCoords.DATA_MODEL_SLOT.Y, DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.WIDTH, DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.HEIGHT);
        return Collections.singletonList(new Rectangle(
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.LEFT + gui.getGuiLeft(),
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.TOP + gui.getGuiTop(),
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.WIDTH,
            DMLConstants.Gui.SimulationChamber.DATA_MODEL_SLOT.HEIGHT
        ));
    }
}
