package zzzank.mod.jei_area_fixer.mixin.blue_skies;

import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.blue_skies.SkyTabAccessor;

/**
 * @author ZZZank
 */
@Mixin(value = SkyTab.class, remap = false)
public interface AccessSkyTab extends SkyTabAccessor {

    @Accessor("slidePos")
    @Override
    int jaf$slidePos();
}
