package zzzank.mod.jei_area_fixer.mods.rftools;

import mcjty.rftools.blocks.storagemonitor.GuiStorageScanner;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class StorageScannerArea extends AbstractJEIAreaProvider<GuiStorageScanner> {

    public StorageScannerArea() {
        super(GuiStorageScanner.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiStorageScanner gui) {
        var craftingGrid = ((StorageWithCraftGuiAccessor) gui).get$craftingGrid();
        var window = ((GuiCraftingGridAccessor) craftingGrid).get$craftWindow();
        return JEIAreaFixer.nullableWrap(window.getToplevel().getBounds());
    }
}
