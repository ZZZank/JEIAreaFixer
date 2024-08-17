package zzzank.mod.jei_area_fixer.mixin.rftools;

import mcjty.lib.gui.Window;
import mcjty.rftools.craftinggrid.GuiCraftingGrid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.rftools.GuiCraftingGridAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiCraftingGrid.class)
public interface AccessGuiCraftingGrid extends GuiCraftingGridAccessor {

    @Accessor(value = "craftWindow", remap = false)
    Window get$craftWindow();
}
