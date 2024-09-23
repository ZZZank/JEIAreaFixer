package zzzank.mod.jei_area_fixer.mixin.tinker_io;

import net.minecraft.client.gui.GuiButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import tinker_io.gui.GuiSmartOutput;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(value = GuiSmartOutput.class, remap = false)
public abstract class MixinGuiSmartOutput implements JEIAreaProvider {

    @Shadow
    private GuiButton buttonEmptyTank;

    @Nullable
    @Override
    public List<Rectangle> jei_area_fixer$getAreas() {
        return this.buttonEmptyTank == null
            ? null
            : Collections.singletonList(JEIAreaFixer.rectFromButton(this.buttonEmptyTank));
    }
}
