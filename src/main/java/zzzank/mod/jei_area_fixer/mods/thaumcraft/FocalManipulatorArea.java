package zzzank.mod.jei_area_fixer.mods.thaumcraft;

import lombok.val;
import thaumcraft.client.gui.GuiFocalManipulator;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
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
        val invArea = new Rectangle(k - 71, l - 3, 71, 239); //this.drawTexturedModalRect(k - 71, l - 3, 0, 0, 71, 239);

        if (!JEIAreaFixerConfig.THAUMCRAFT.focalManipulatorExtra || !gui.inventorySlots.getSlot(0).getHasStack()) {
            return Collections.singletonList(invArea);
        }

        val rightSideArea = new Rectangle(
            k + 230,
            gui.getGuiTop() + AreaFilter.JEI_BOOKMARK_TOP_HEIGHT,
            // 71 is magic number picked without much thought
            71,
            // 239 is also magic number, subtracting JEI related height TWICE to avoid overlapping with
            // JEI button at the top and search bar at the bottom
            239 - AreaFilter.JEI_BOOKMARK_TOP_HEIGHT * 2
        );
        return Arrays.asList(invArea, rightSideArea);
    }
}
