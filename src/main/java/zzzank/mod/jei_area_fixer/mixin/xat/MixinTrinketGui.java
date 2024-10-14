package zzzank.mod.jei_area_fixer.mixin.xat;

import lombok.val;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import xzeroair.trinkets.client.gui.TrinketGui;
import zzzank.mod.jei_area_fixer.mods.trinkets_and_baubles.TrinketGuiAreaProvider;

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
            ordinal = 0,
            args = "intValue=64"
        ),
        remap = false,
        locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void jaf$clearCachedArea(int x, int y, CallbackInfo ci, int slots, int columnLength, int maxColumns) {
        jaf$areas.clear();
        for (int col = 0; col < maxColumns; col++) {
            val rows = Math.min(slots, columnLength);
            slots -= columnLength;
            int height = rows * 18;
            /*why add additional height when there's more than 4 and 7 columns:
            if (l == 4 || l == 7) {
                this.drawTexturedModalRect(X - 5 - c * 18, Y - 0 + l * 18, texX + 96, 8, 23, 8);
                Y += 4;
            }
            */
            if (rows > 4) {
                height += 4;
            }
            if (rows > 7) {
                height += 4;
            }
            jaf$areas.add(new Rectangle(x - col * 18, y, 18, height));
        }
    }

    @Override
    public List<Rectangle> jaf$getAreas() {
        return jaf$areas;
    }
}
