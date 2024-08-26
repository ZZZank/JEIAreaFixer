package zzzank.mod.jei_area_fixer.mods.xnet;

import mcjty.xnet.blocks.controller.gui.GuiController;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class XNetControllerArea extends AbstractJEIAreaProvider<GuiController> {

    public XNetControllerArea() {
        super(GuiController.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiController gui) {
        var connectorList = ((GuiControllerAccessor) gui).get$connectorList();
        var bound = connectorList.getBounds();
        return JEIAreaFixer.nullableWrap(bound);
    }
}
