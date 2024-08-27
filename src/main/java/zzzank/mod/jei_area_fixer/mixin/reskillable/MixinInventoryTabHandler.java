package zzzank.mod.jei_area_fixer.mixin.reskillable;

import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import codersafterdark.reskillable.client.gui.handler.InventoryTabHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import zzzank.mod.jei_area_fixer.mods.reskillable.ReskillableTabArea;

/**
 * @author ZZZank
 */
@Mixin(InventoryTabHandler.class)
public abstract class MixinInventoryTabHandler {

    @ModifyArg(
        method = "addTabs",
        at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"),
        remap = false
    )
    private static Object captureTabs(Object e) {
        ReskillableTabArea.acceptButton((GuiButtonInventoryTab) e);
        return e;
    }
}
