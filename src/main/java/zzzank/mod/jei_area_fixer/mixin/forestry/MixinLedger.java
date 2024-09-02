package zzzank.mod.jei_area_fixer.mixin.forestry;

import forestry.core.gui.ledgers.Ledger;
import forestry.core.gui.ledgers.LedgerManager;
import org.spongepowered.asm.mixin.Final;
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
 *
 * @author ZZZank
 */
@Mixin(value = Ledger.class, remap = false)
public abstract class MixinLedger {

    @Shadow
    @Final
    protected LedgerManager manager;
    @Shadow
    protected float currentWidth;
    @Shadow
    protected float currentHeight;
    @Shadow
    private int x;
    @Shadow
    private int y;

    @Unique
    private boolean jeiAreaFixer$atRight;

    @Inject(method = "<init>(Lforestry/core/gui/ledgers/LedgerManager;Ljava/lang/String;Z)V", at = @At("RETURN"))
    public void captureVariable(LedgerManager manager, String name, boolean rightSide, CallbackInfo ci) {
        jeiAreaFixer$atRight = rightSide;
    }

    @Inject(method = "getArea", at = @At("HEAD"), cancellable = true)
    public void fixLeftLedgerArea(CallbackInfoReturnable<Rectangle> cir) {
        if (!jeiAreaFixer$atRight) {
            final var gui = this.manager.gui;
            cir.setReturnValue(new Rectangle(
                gui.getGuiLeft() + this.x - gui.width - (int) this.currentWidth,
                gui.getGuiTop() + this.y,
                (int) this.currentWidth,
                (int) this.currentHeight
            ));
        }
    }
}
