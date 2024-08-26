package zzzank.mod.jei_area_fixer.mods.xnet;

import mcjty.xnet.blocks.router.GuiRouter;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class XNetRouterArea extends AbstractJEIAreaProvider<GuiRouter> {

    public XNetRouterArea() {
        super(GuiRouter.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiRouter gui) {
        return JEIAreaFixer.nullableWrap(gui.getWindow().getToplevel().getBounds());
    }
}
