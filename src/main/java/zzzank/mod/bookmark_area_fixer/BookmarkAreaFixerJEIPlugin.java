package zzzank.mod.bookmark_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

/**
 * @author ZZZank
 */
@JEIPlugin
public class BookmarkAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(IModRegistry registry) {
        registry.addAdvancedGuiHandlers(null);
    }
}
