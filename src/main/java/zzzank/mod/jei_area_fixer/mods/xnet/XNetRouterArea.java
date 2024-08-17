package zzzank.mod.jei_area_fixer.mods.xnet;

import mcjty.xnet.blocks.router.GuiRouter;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class XNetRouterArea implements IAdvancedGuiHandler<GuiRouter> {
    @Override
    @Nonnull
    public Class<GuiRouter> getGuiContainerClass() {
        return GuiRouter.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(@Nonnull GuiRouter gui) {
        var bound = gui.getWindow().getToplevel().getBounds();
        return JEIAreaFixer.nullableWrap(bound);
    }
}
