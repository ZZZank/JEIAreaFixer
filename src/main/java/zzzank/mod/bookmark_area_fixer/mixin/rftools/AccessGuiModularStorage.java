package zzzank.mod.bookmark_area_fixer.mixin.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import mcjty.rftools.craftinggrid.GuiCraftingGrid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.bookmark_area_fixer.mods.rftools.GuiModularStorageAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiModularStorage.class)
public interface AccessGuiModularStorage extends GuiModularStorageAccessor {

    @Accessor(value = "craftingGrid",remap = false)
    GuiCraftingGrid jeiArea$craftingGrid();
}
