package zzzank.mod.bookmark_area_fixer.mods.xnet;

import mcjty.xnet.blocks.router.GuiRouter;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.bookmark_area_fixer.BookmarkAreaFixer;

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
        return BookmarkAreaFixer.nullableWrap(bound);
    }
}
