package zzzank.mod.jei_area_fixer.mixin.xat;

import lombok.val;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xzeroair.trinkets.client.gui.TrinketGui;
import zzzank.mod.jei_area_fixer.mods.xat.TrinketGuiAreaProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(TrinketGui.class)
public abstract class MixinTrinketGui implements TrinketGuiAreaProvider {

    @Unique
    private final ArrayList<Rectangle> jaf$areas = new ArrayList<>();

    @Inject(
        method = "renderTrinketInventory",
        at = @At(
            value = "CONSTANT",
            args = "intValue=0",
            ordinal = 0
        ),
        remap = false,
        locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void jaf$clearCachedArea(
        int x,
        int y,
        CallbackInfo ci,
        int slots,
        final int columnLength,
        final int maxColumns,
        int ignoredX,
        int ignoredY,
        int texX,
        int texY
    ) {
        jaf$areas.clear();
        for (int col = 0; col < columnLength; col++) {
            val rows = Math.min(slots, columnLength);
            slots -= columnLength;
            jaf$areas.add(new Rectangle(x - 14 - col * 18, y, 32, 32 + rows * 18));
        }
    }

    @Override
    public List<Rectangle> jaf$getAreas() {
        return jaf$areas;
    }
}
