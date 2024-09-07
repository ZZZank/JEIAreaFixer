package zzzank.mod.jei_area_fixer.mixin.jei;

import mezz.jei.gui.GuiScreenHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.debug.JEIAreaFixerDebugAction;

import java.awt.*;
import java.util.Set;

/**
 * @author ZZZank
 */
@Mixin(value = GuiScreenHelper.class, remap = false)
public abstract class MixinGuiScreenHelper {

    @Inject(method = "getPluginsExclusionAreas", at = @At("RETURN"))
    public void jeiAreaFixer$captureExclusionArea(CallbackInfoReturnable<Set<Rectangle>> cir) {
        if (JEIAreaFixerConfig.debug$drawAll) {
            JEIAreaFixerDebugAction.capturedAreas = cir.getReturnValue();
        }
    }
}
