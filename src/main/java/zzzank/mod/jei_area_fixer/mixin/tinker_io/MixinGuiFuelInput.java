package zzzank.mod.jei_area_fixer.mixin.tinker_io;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tinker_io.gui.GuiFuelInputMachine;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(value = GuiFuelInputMachine.class, remap = false)
public abstract class MixinGuiFuelInput implements JEIAreaProvider {

    @Unique
    private final List<Rectangle> jeiAreaFixer$captured = Collections.singletonList(new Rectangle());

    @Redirect(
        method = "drawGuiContainerBackgroundLayer",
        at = @At(
            value = "INVOKE",
            target = "Ltinker_io/gui/GuiFuelInputMachine;drawTexturedModalRect(IIIIII)V",
            ordinal = 1
        )
    )
    private void jeiAreaFixer$captureArea(
        GuiFuelInputMachine instance,
        int x,
        int y,
        int textureX,
        int textureY,
        int width,
        int height
    ) {
        jeiAreaFixer$captured.get(0).setBounds(x, y, width, height);
    }

    @Nullable
    @Override
    public List<Rectangle> jei_area_fixer$getAreas() {
        return jeiAreaFixer$captured;
    }
}
