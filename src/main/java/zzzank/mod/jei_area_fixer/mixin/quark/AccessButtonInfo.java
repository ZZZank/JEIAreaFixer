package zzzank.mod.jei_area_fixer.mixin.quark;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.quark.ButtonInfoAccessor;

/**
 * @author ZZZank
 */
@Mixin(targets = "vazkii.quark.management.feature.ChestButtons$ButtonInfo",remap = false)
public interface AccessButtonInfo extends ButtonInfoAccessor {

    @Accessor("enabled")
    boolean get$enabled();

    @Accessor("xShift")
    int get$xShift();

    @Accessor("yShift")
    int get$yShift();
}
