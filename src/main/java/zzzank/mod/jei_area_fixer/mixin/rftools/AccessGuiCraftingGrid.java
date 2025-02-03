package zzzank.mod.jei_area_fixer.mixin.rftools;

import mcjty.lib.gui.Window;
import mcjty.rftools.craftinggrid.GuiCraftingGrid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author ZZZank
 */
@Mixin(GuiCraftingGrid.class)
public interface AccessGuiCraftingGrid {

    @Accessor(value = "craftWindow", remap = false)
    Window jaf$craftWindow();
}
