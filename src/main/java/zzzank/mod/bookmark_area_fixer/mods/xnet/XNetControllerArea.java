package zzzank.mod.bookmark_area_fixer.mods.xnet;

import mcjty.xnet.blocks.controller.gui.GuiController;
import mezz.jei.api.gui.IAdvancedGuiHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class XNetControllerArea implements IAdvancedGuiHandler<GuiController> {
    @Override
    @Nonnull
    public Class<GuiController> getGuiContainerClass() {
        return GuiController.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(@Nonnull GuiController gui) {
        var connectorList = ((GuiContainerAccessor) gui).jeiArea$connectorList();
        var bound = connectorList.getBounds();
        return bound == null ? Collections.emptyList() : Collections.singletonList(bound);
    }
}
