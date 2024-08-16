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
        var channelPanel = ((GuiContainerAccessor) gui).jeiarea$channelEditPanel();
        return Collections.singletonList(channelPanel.getBounds());
    }
}
