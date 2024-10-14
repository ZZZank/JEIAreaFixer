package zzzank.mod.jei_area_fixer.mixin.openmods;

import openmods.gui.ComponentGui;
import openmods.gui.component.BaseComposite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.open_mods.ComponentGuiAccessor;

/**
 * @author ZZZank
 */
@Mixin(ComponentGui.class)
public interface AccessComponentGui extends ComponentGuiAccessor {

    @Accessor(value = "root", remap = false)
    BaseComposite jaf$root();
}
