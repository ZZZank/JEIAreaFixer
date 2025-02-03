package zzzank.mod.jei_area_fixer.mixin.craftingtweaks;

import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiTweakButton.class, remap = false)
public interface AccessGuiTweakButton {

    @Accessor("lastGuiLeft")
    int jaf$lastGuiLeft();

    @Accessor("lastGuiTop")
    int jaf$lastGuiTop();
}
