package zzzank.mod.bookmark_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zzzank.mod.bookmark_area_fixer.mods.ModState;
import zzzank.mod.bookmark_area_fixer.mods.xnet.XNetControllerArea;

import javax.annotation.Nonnull;

/**
 * @author ZZZank
 */
@JEIPlugin
public class BookmarkAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        if (ModState.XNET) {
            registry.addAdvancedGuiHandlers(new XNetControllerArea());
        }
    }
}
