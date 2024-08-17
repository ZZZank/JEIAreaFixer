package zzzank.mod.bookmark_area_fixer.mods.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.bookmark_area_fixer.BookmarkAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class ModularStorageArea implements IAdvancedGuiHandler<GuiModularStorage> {
    @Override
    @Nonnull
    public Class<GuiModularStorage> getGuiContainerClass() {
        return GuiModularStorage.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(@Nonnull GuiModularStorage gui) {
        var craftingGrid = ((StorageWithCraftGuiAccessor) gui).get$craftingGrid();
        var window = ((GuiCraftingGridAccessor) craftingGrid).get$craftWindow();
        var bound = window.getToplevel().getBounds();
        return BookmarkAreaFixer.nullableWrap(bound);
    }
}
