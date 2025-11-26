package zzzank.mod.jei_area_fixer.mods.deep_mob_learning;

import xt9.deepmoblearning.client.gui.TrialKeystoneGui;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class TrialKeystoneArea extends AbstractJEIAreaProvider<TrialKeystoneGui> {
    @Nonnull
    @Override
    protected Class<TrialKeystoneGui> getTarget() {
        return TrialKeystoneGui.class;
    }

    /// @see TrialKeystoneGui#drawGuiContainerBackgroundLayer(float, int, int)
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull TrialKeystoneGui gui) {
        // this.drawTexturedModalRect(left - 20, top, 0, 100, 18, 18);
        return Collections.singletonList(
            new Rectangle(
                gui.getGuiLeft() - 20,
                gui.getGuiTop(),
                18,
                18
            )
        );
    }
}
