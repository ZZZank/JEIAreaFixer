package zzzank.mod.jei_area_fixer.mixin.openmods;

import openmods.gui.component.BaseComponent;
import openmods.gui.component.BaseComposite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(BaseComposite.class)
public interface AccessBaseComposite {

    @Accessor(value = "components", remap = false)
    List<BaseComponent> jaf$components();
}
