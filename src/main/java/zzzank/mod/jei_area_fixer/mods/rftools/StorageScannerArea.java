package zzzank.mod.jei_area_fixer.mods.rftools;

import lombok.val;
import mcjty.rftools.blocks.storagemonitor.GuiStorageScanner;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mixin.rftools.AccessGuiCraftingGrid;
import zzzank.mod.jei_area_fixer.mixin.rftools.AccessStorageWithCraftGui;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class StorageScannerArea extends AbstractJEIAreaProvider<GuiStorageScanner> {

    @Nonnull
    @Override
    protected Class<GuiStorageScanner> getTarget() {
        return GuiStorageScanner.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiStorageScanner gui) {
        val craftingGrid = ((AccessStorageWithCraftGui) gui).jaf$craftingGrid();
        val window = ((AccessGuiCraftingGrid) craftingGrid).jaf$craftWindow();
        return JEIAreaFixer.nullableWrap(window.getToplevel().getBounds());
    }
}
