package zzzank.mod.jei_area_fixer;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraftforge.common.MinecraftForge;
import zzzank.mod.jei_area_fixer.mods.GeneralButtonsArea;
import zzzank.mod.jei_area_fixer.mods.ModState;
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
    }
}
