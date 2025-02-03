package zzzank.mod.jei_area_fixer.mixin.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import mcjty.rftools.blocks.storagemonitor.GuiStorageScanner;
import mcjty.rftools.craftinggrid.GuiCraftingGrid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author ZZZank
 */
@Mixin({GuiModularStorage.class, GuiStorageScanner.class})
public interface AccessStorageWithCraftGui {

    @Accessor(value = "craftingGrid",remap = false)
    GuiCraftingGrid jaf$craftingGrid();
}
