package zzzank.mod.jei_area_fixer.mixin.craftingtweaks;

import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.crafting_tweaks.GuiTweakButtonAccessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiTweakButton.class, remap = false)
public interface AccessGuiTweakButton extends GuiTweakButtonAccessor {

    @Accessor("lastGuiLeft")
    @Override
    int jaf$lastGuiLeft();

    @Accessor("lastGuiTop")
    @Override
    int jaf$lastGuiTop();
}
