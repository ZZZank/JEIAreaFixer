package zzzank.mod.jei_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import zzzank.mod.jei_area_fixer.mods.GeneralButtonsArea;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.appliedenergistics2.AE2ButtonsArea;
import zzzank.mod.jei_area_fixer.mods.appliedenergistics2.AE2CellViewArea;
import zzzank.mod.jei_area_fixer.mods.blue_skies.BlueSkiesTabArea;
import zzzank.mod.jei_area_fixer.mods.computercraft.ComputerScreenArea;
import zzzank.mod.jei_area_fixer.mods.cyclic.ExtendedArmorInventoryArea;
import zzzank.mod.jei_area_fixer.mods.forestry.ForestryLedgersArea;
import zzzank.mod.jei_area_fixer.mods.gamblingstyle.GuiVillagerArea;
import zzzank.mod.jei_area_fixer.mods.mcjtylib.GenericGuiContainerArea;
import zzzank.mod.jei_area_fixer.mods.smelteryio.CastingMachineArea;
import zzzank.mod.jei_area_fixer.mods.smelteryio.FuelControllerArea;
import zzzank.mod.jei_area_fixer.mods.openmods.OpenModsSeriesGuiArea;
import zzzank.mod.jei_area_fixer.mods.quark.ChestButtonsArea;
import zzzank.mod.jei_area_fixer.mods.reskillable.ReskillableTabArea;
import zzzank.mod.jei_area_fixer.mods.rftools.ModularStorageArea;
import zzzank.mod.jei_area_fixer.mods.rftools.StorageScannerArea;
import zzzank.mod.jei_area_fixer.mods.tinker_io.TinkerIOFuelInputMachineArea;
import zzzank.mod.jei_area_fixer.mods.tinker_io.TinkerIOSmartOutputArea;

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
        if (ModState.QUARK) {
            if (Quark$ChestButtons) {
                registry.addAdvancedGuiHandlers(new ChestButtonsArea());
            }
        }
        if (ModState.FORESTRY) {
            if (Forestry$Tabs) {
                registry.addAdvancedGuiHandlers(new ForestryLedgersArea());
            }
        }
        if (ModState.CYCLIC) {
            if (Cyclic$ExtendedInventory) {
                registry.addAdvancedGuiHandlers(new ExtendedArmorInventoryArea());
            }
        }
        if (ModState.MCJTY_LIB) {
            if (McjtyLib$General) {
                registry.addAdvancedGuiHandlers(new GenericGuiContainerArea());
            }
        }
        if (ModState.COMPUTER_CRAFT) {
            if (ComputerCraft$Computer) {
                registry.addAdvancedGuiHandlers(new ComputerScreenArea());
            }
        }
        if (shouldEnableForAE2()) {
            if (AE2$Buttons) {
                registry.addAdvancedGuiHandlers(new AE2ButtonsArea());
            }
            if (AE2$CellView) {
                registry.addAdvancedGuiHandlers(new AE2CellViewArea());
            }
        }
        if (ModState.TINKER_IO && TinkerIO$All) {
            if (TinkerIO$FuelInput) {
                registry.addAdvancedGuiHandlers(new TinkerIOFuelInputMachineArea());
            }
            if (TinkerIO$SmartOutput) {
                registry.addAdvancedGuiHandlers(new TinkerIOSmartOutputArea());
            }
        }
        if (ModState.BLUE_SKIES) {
            if (BlueSkies$Tabs) {
                registry.addAdvancedGuiHandlers(new BlueSkiesTabArea());
            }
        }
    }

    private static boolean shouldEnableForAE2() {
        if (!ModState.AE2) {
            return false;
        }
        var ae2 = Loader.instance().getIndexedModList().get("appliedenergistics2");
        if (ae2 == null) {
            return false;
        }
        if (AE2$DetectAE2UEL && ae2.getVersion().startsWith("v")) {
            //AE2-UEL installed
            return false;
        }
        return AE2$All;
    }
}
