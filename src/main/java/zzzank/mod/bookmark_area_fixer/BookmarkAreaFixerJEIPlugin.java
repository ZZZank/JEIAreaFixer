package zzzank.mod.bookmark_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zzzank.mod.bookmark_area_fixer.mods.xnet.XNetControllerArea;

/**
 * @author ZZZank
 */
@JEIPlugin
public class BookmarkAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        registry.addAdvancedGuiHandlers(new XNetControllerArea());
    }
}
