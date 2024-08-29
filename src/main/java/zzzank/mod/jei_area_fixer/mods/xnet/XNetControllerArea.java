package zzzank.mod.jei_area_fixer.mods.xnet;

import mcjty.xnet.blocks.controller.gui.GuiController;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

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
        return ((JEIAreaProvider) gui).jei_area_fixer$getAreas();
    }
}
