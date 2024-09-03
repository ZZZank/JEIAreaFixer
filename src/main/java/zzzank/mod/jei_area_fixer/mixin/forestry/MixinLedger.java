package zzzank.mod.jei_area_fixer.mixin.forestry;

import forestry.core.gui.ledgers.Ledger;
import forestry.core.gui.ledgers.LedgerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;

/**
 * fix stupid Ledger area calculation ignoring left side situation
 * <p>
 * see {@link LedgerManager#getAtPosition(int, int)} for why using {@link Ledger#currentShiftX} and {@link Ledger#currentShiftY}
 *
 * @author ZZZank
 */
@Mixin(value = Ledger.class, remap = false)
public abstract class MixinLedger {

    @Shadow
    public int currentShiftY;
    @Shadow
    public int currentShiftX;
    @Shadow
    private int x;
    @Shadow
    private int y;
    @Unique
    private boolean jeiAreaFixer$atRight;

    @Shadow
    public abstract int getWidth();

    @Shadow
    public abstract int getHeight();

    @Inject(method = "<init>(Lforestry/core/gui/ledgers/LedgerManager;Ljava/lang/String;Z)V", at = @At("RETURN"))
    public void captureVariable(LedgerManager manager, String name, boolean rightSide, CallbackInfo ci) {
        jeiAreaFixer$atRight = rightSide;
    }

    @Inject(method = "getArea", at = @At("HEAD"), cancellable = true)
    public void fixLeftLedgerArea(CallbackInfoReturnable<Rectangle> cir) {
        if (jeiAreaFixer$atRight) {
            return;
        }
        cir.setReturnValue(new Rectangle(
            this.x + this.currentShiftX,
            this.y + this.currentShiftY,
            this.getWidth(),
            this.getHeight()
        ));
    }
}
