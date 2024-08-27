package zzzank.mod.jei_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraftforge.common.MinecraftForge;
import zzzank.mod.jei_area_fixer.mods.GeneralButtonsArea;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.gamblingstyle.GuiVillagerArea;
import zzzank.mod.jei_area_fixer.mods.mctsmelteryio.CastingMachineArea;
import zzzank.mod.jei_area_fixer.mods.mctsmelteryio.FuelControllerArea;
import zzzank.mod.jei_area_fixer.mods.openmods.OpenModsSeriesGuiArea;
import zzzank.mod.jei_area_fixer.mods.reskillable.ReskillableTabArea;
import zzzank.mod.jei_area_fixer.mods.rftools.ModularStorageArea;
import zzzank.mod.jei_area_fixer.mods.rftools.StorageScannerArea;
import zzzank.mod.jei_area_fixer.mods.xnet.XNetControllerArea;
import zzzank.mod.jei_area_fixer.mods.xnet.XNetRouterArea;

import javax.annotation.Nonnull;

import static zzzank.mod.jei_area_fixer.JEIAreaFixerConfig.*;

/**
 * @author ZZZank
 */
@JEIPlugin
public class JEIAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        if (General$Buttons) {
            var buttonsArea = new GeneralButtonsArea();
            registry.addAdvancedGuiHandlers(buttonsArea);
            MinecraftForge.EVENT_BUS.register(buttonsArea);
        }
        if (ModState.X_NET && XNet$All) {
            if (XNet$Controller) {
                registry.addAdvancedGuiHandlers(new XNetControllerArea());
            }
            if (XNet$Router) {
                registry.addAdvancedGuiHandlers(new XNetRouterArea());
            }
        }
        if (ModState.RF_TOOLS && RFTools$All) {
            if (RFTools$ModularStorage) {
                registry.addAdvancedGuiHandlers(new ModularStorageArea());
            }
            if (RFTools$StorageScanner) {
                registry.addAdvancedGuiHandlers(new StorageScannerArea());
            }
        }
        if (ModState.GAMBLING_STYLE && GamblingStyle$All) {
            registry.addAdvancedGuiHandlers(new GuiVillagerArea());
        }
        if (ModState.OPEN_MODS_LIB && OpenMods$All) {
            registry.addAdvancedGuiHandlers(new OpenModsSeriesGuiArea());
        }
        if (ModState.SMELTERY_IO && SmelteryIO$All) {
            if (SmelteryIO$CastingMachine) {
                registry.addAdvancedGuiHandlers(new FuelControllerArea());
            }
            if (SmelteryIO$FuelController) {
                registry.addAdvancedGuiHandlers(new CastingMachineArea());
            }
        }
        if (ModState.RESKILLABLE) {
            if (Reskillable$Tabs) {
                registry.addAdvancedGuiHandlers(new ReskillableTabArea());
            }
        }
    }
}
