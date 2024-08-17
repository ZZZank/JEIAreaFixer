package zzzank.mod.bookmark_area_fixer.mixin.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import mcjty.rftools.blocks.storagemonitor.GuiStorageScanner;
import mcjty.rftools.craftinggrid.GuiCraftingGrid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.bookmark_area_fixer.mods.rftools.StorageWithCraftGuiAccessor;

/**
 * @author ZZZank
 */
@Mixin({GuiModularStorage.class, GuiStorageScanner.class})
public interface AccessStorageWithCraft extends StorageWithCraftGuiAccessor {

    @Accessor(value = "craftingGrid",remap = false)
    GuiCraftingGrid get$craftingGrid();
}
