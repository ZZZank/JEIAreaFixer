package zzzank.mod.jei_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.gamblingstyle.GuiVillagerArea;
import zzzank.mod.jei_area_fixer.mods.mctsmelteryio.GuiFuelControllerArea;
import zzzank.mod.jei_area_fixer.mods.openmods.OpenModsSeriesGuiArea;
import zzzank.mod.jei_area_fixer.mods.rftools.ModularStorageArea;
import zzzank.mod.jei_area_fixer.mods.rftools.StorageScannerArea;
import zzzank.mod.jei_area_fixer.mods.xnet.XNetControllerArea;
import zzzank.mod.jei_area_fixer.mods.xnet.XNetRouterArea;

import javax.annotation.Nonnull;

/**
 * @author ZZZank
 */
@JEIPlugin
public class JEIAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        if (ModState.X_NET && JEIAreaFixerConfig.enableForXNet) {
            registry.addAdvancedGuiHandlers(new XNetControllerArea());
            registry.addAdvancedGuiHandlers(new XNetRouterArea());
        }
        if (ModState.RF_TOOLS && JEIAreaFixerConfig.enableForRFTools) {
            registry.addAdvancedGuiHandlers(new ModularStorageArea());
            registry.addAdvancedGuiHandlers(new StorageScannerArea());
        }
        if (ModState.GAMBLING_STYLE && JEIAreaFixerConfig.enableForGamblingStyle) {
            registry.addAdvancedGuiHandlers(new GuiVillagerArea());
        }
        if (ModState.OPEN_MODS_LIB && JEIAreaFixerConfig.enableForOpenMods) {
            registry.addAdvancedGuiHandlers(new OpenModsSeriesGuiArea());
        }
        if (ModState.SMELTERY_IO && JEIAreaFixerConfig.enableForSmelteryIO) {
            registry.addAdvancedGuiHandlers(new GuiFuelControllerArea());
        }
    }
}
