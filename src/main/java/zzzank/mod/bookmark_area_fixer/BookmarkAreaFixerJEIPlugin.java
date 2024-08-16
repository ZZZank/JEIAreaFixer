package zzzank.mod.bookmark_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zzzank.mod.bookmark_area_fixer.mods.ModState;
import zzzank.mod.bookmark_area_fixer.mods.rftools.ModularStorageArea;
import zzzank.mod.bookmark_area_fixer.mods.rftools.StorageScannerArea;
import zzzank.mod.bookmark_area_fixer.mods.xnet.XNetControllerArea;
import zzzank.mod.bookmark_area_fixer.mods.xnet.XNetRouterArea;

import javax.annotation.Nonnull;

/**
 * @author ZZZank
 */
@JEIPlugin
public class BookmarkAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        if (ModState.XNET && BookmarkAreaFixerConfig.enableForXNet) {
            registry.addAdvancedGuiHandlers(new XNetControllerArea());
            registry.addAdvancedGuiHandlers(new XNetRouterArea());
        }
        if (ModState.RFTOOLS && BookmarkAreaFixerConfig.enableForRFTools) {
            registry.addAdvancedGuiHandlers(new ModularStorageArea());
            registry.addAdvancedGuiHandlers(new StorageScannerArea());
        }
    }
}
