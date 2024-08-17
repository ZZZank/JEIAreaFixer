package zzzank.mod.jei_area_fixer.mods.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

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
        return JEIAreaFixer.nullableWrap(bound);
    }
}
