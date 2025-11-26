package zzzank.mod.jei_area_fixer.mods.dme;

import mustapelto.deepmoblearning.client.gui.GuiTrialKeystone;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

import static mustapelto.deepmoblearning.DMLConstants.Gui.TrialKeystone.TRIAL_KEY_SLOT;

/**
 * @author ZZZank
 */
public class DMETrialKeystoneArea extends AbstractJEIAreaProvider<GuiTrialKeystone> {
    @Nonnull
    @Override
    protected Class<GuiTrialKeystone> getTarget() {
        return GuiTrialKeystone.class;
    }

    /// @see GuiTrialKeystone#drawGuiContainerBackgroundLayer(float, int, int)
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiTrialKeystone gui) {
        return Collections.singletonList(
            new Rectangle(
                gui.getGuiLeft() + TRIAL_KEY_SLOT.LEFT,
                gui.getGuiTop() + TRIAL_KEY_SLOT.TOP,
                TRIAL_KEY_SLOT.WIDTH,
                TRIAL_KEY_SLOT.HEIGHT
            )
        );
    }
}
