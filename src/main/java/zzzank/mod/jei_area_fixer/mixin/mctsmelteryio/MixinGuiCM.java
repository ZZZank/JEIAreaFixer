package zzzank.mod.jei_area_fixer.mixin.mctsmelteryio;

import mctmods.smelteryio.tileentity.gui.GuiCM;
import net.minecraft.client.gui.GuiButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(GuiCM.class)
public abstract class MixinGuiCM implements JEIAreaProvider {

    @Shadow(remap = false)
    private GuiButton buttonEmptyTank;

    @Shadow(remap = false)
    private GuiButton buttonLockSlots;

    @Override
    public @Nullable List<Rectangle> jei_area_fixer$getAreas() {
        return Arrays.asList(
            new Rectangle(buttonEmptyTank.x, buttonEmptyTank.y, buttonEmptyTank.width, buttonEmptyTank.height),
            new Rectangle(buttonLockSlots.x, buttonLockSlots.y, buttonLockSlots.width, buttonLockSlots.height)
        );
    }
}
