package zzzank.mod.jei_area_fixer.mods.deep_mob_learning;

import xt9.deepmoblearning.client.gui.SimulationChamberGui;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class SimulationChamberArea extends AbstractJEIAreaProvider<SimulationChamberGui> {

    @Nonnull
    @Override
    protected Class<SimulationChamberGui> getTarget() {
        return SimulationChamberGui.class;
    }

    /**
     * @see SimulationChamberGui#drawGuiContainerBackgroundLayer(float, int, int)
     */
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull SimulationChamberGui gui) {
        // int left = this.getGuiLeft() + 8;
        // int top = this.getGuiTop();
        // this.drawTexturedModalRect(left - 22, top, 0, 141, 18, 18);
        return Collections.singletonList(new Rectangle(
            gui.getGuiLeft() + 8 - 22,
            gui.getGuiTop(),
            18,
            18
        ));
    }
}
