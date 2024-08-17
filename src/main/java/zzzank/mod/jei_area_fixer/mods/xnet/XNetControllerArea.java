package zzzank.mod.jei_area_fixer.mods.xnet;

import mcjty.xnet.blocks.controller.gui.GuiController;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
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
        var connectorList = ((GuiControllerAccessor) gui).get$connectorList();
        var bound = connectorList.getBounds();
        return JEIAreaFixer.nullableWrap(bound);
    }
}
