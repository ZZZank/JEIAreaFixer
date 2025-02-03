package zzzank.mod.jei_area_fixer.mods.thaumcraft;

import lombok.val;
import thaumcraft.client.gui.GuiFocalManipulator;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class FocalManipulatorArea extends AbstractJEIAreaProvider<GuiFocalManipulator> {

    @Nonnull
    @Override
    protected Class<GuiFocalManipulator> getTarget() {
        return GuiFocalManipulator.class;
    }

    /**
     * @see GuiFocalManipulator#drawGuiContainerBackgroundLayer(float, int, int)
     */
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiFocalManipulator gui) {
        val k = (gui.width - gui.getXSize()) / 2;
        val l = (gui.height - gui.getYSize()) / 2;
        return Collections.singletonList(
            new Rectangle(k - 71, l - 3, 71, 239) //this.drawTexturedModalRect(k - 71, l - 3, 0, 0, 71, 239);
        );
    }
}
