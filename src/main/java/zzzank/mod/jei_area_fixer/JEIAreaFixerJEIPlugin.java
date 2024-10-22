package zzzank.mod.jei_area_fixer;

import lombok.AllArgsConstructor;
import lombok.val;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import zzzank.mod.jei_area_fixer.mods.GeneralButtonsArea;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.ae2wtlib.AE2WTLibButtonsArea;
import zzzank.mod.jei_area_fixer.mods.ae2wtlib.WirelessCraftingAdditionalArea;
import zzzank.mod.jei_area_fixer.mods.applied_energistics_2.AE2ButtonsArea;
import zzzank.mod.jei_area_fixer.mods.applied_energistics_2.AE2CellViewArea;
import zzzank.mod.jei_area_fixer.mods.blue_skies.BlueSkiesTabArea;
import zzzank.mod.jei_area_fixer.mods.computer_craft.ComputerScreenArea;
import zzzank.mod.jei_area_fixer.mods.crafting_tweaks.CraftingTweaksButtonArea;
import zzzank.mod.jei_area_fixer.mods.cyclic.ExtendedArmorInventoryArea;
import zzzank.mod.jei_area_fixer.mods.deep_mob_learning.DMLRedstoneModeButtonArea;
import zzzank.mod.jei_area_fixer.mods.deep_mob_learning.SimulationChamberArea;
import zzzank.mod.jei_area_fixer.mods.forestry.ForestryLedgersArea;
import zzzank.mod.jei_area_fixer.mods.gambling_style.GuiVillagerArea;
import zzzank.mod.jei_area_fixer.mods.mcjty_lib.GenericGuiContainerArea;
import zzzank.mod.jei_area_fixer.mods.smeltery_io.CastingMachineArea;
import zzzank.mod.jei_area_fixer.mods.smeltery_io.FuelControllerArea;
import zzzank.mod.jei_area_fixer.mods.open_mods.OpenModsSeriesGuiArea;
import zzzank.mod.jei_area_fixer.mods.quark.ChestButtonsArea;
import zzzank.mod.jei_area_fixer.mods.reskillable.ReskillableTabArea;
import zzzank.mod.jei_area_fixer.mods.rftools.ModularStorageArea;
import zzzank.mod.jei_area_fixer.mods.rftools.StorageScannerArea;
import zzzank.mod.jei_area_fixer.mods.tinker_io.TinkerIOFuelInputMachineArea;
import zzzank.mod.jei_area_fixer.mods.tinker_io.TinkerIOSmartOutputArea;
import zzzank.mod.jei_area_fixer.mods.trinkets_and_baubles.TrinketGuiArea;
import zzzank.mod.jei_area_fixer.mods.trinkets_and_baubles.TrinketGuiButtonArea;

import javax.annotation.Nonnull;

import java.util.function.Supplier;

import static zzzank.mod.jei_area_fixer.JEIAreaFixerConfig.*;

/**
 * @author ZZZank
 */
@JEIPlugin
public class JEIAreaFixerJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
        val handlers = new GuiHandlersRegistryHelper(registry);
        if (GENERAL.aggressiveButtonCapture) {
            val buttonsArea = new GeneralButtonsArea();
            handlers.add(buttonsArea);
            MinecraftForge.EVENT_BUS.register(buttonsArea);
        }
        if (ModState.RF_TOOLS && RF_TOOLS.all) {
            handlers.addIf(RF_TOOLS.modularStorage, ModularStorageArea::new);
            handlers.addIf(RF_TOOLS.storageScanner, StorageScannerArea::new);
        }
        if (ModState.GAMBLING_STYLE && GAMBLING_STYLE.all) {
            handlers.add(new GuiVillagerArea());
        }
        if (ModState.OPEN_MODS_LIB && OPEN_MODS.all) {
            handlers.add(new OpenModsSeriesGuiArea());
        }
        if (ModState.SMELTERY_IO && SMELTERY_IO.all) {
            handlers.addIf(SMELTERY_IO.castingMachine, FuelControllerArea::new);
            handlers.addIf(SMELTERY_IO.fuelController, CastingMachineArea::new);
        }
        if (ModState.RESKILLABLE) {
            handlers.addIf(RESKILLABLE.tabs, ReskillableTabArea::new);
        }
        if (ModState.QUARK) {
            handlers.addIf(QUARK.chestButtons, ChestButtonsArea::new);
        }
        if (ModState.FORESTRY) {
            handlers.addIf(FORESTRY.tabs, ForestryLedgersArea::new);
        }
        if (ModState.CYCLIC) {
            handlers.addIf(CYCLIC.extendedInventory, ExtendedArmorInventoryArea::new);
        }
        if (ModState.MCJTY_LIB) {
            handlers.addIf(MCJTY_LIB.all, GenericGuiContainerArea::new);
        }
        if (ModState.COMPUTER_CRAFT) {
            handlers.addIf(COMPUTER_CRAFT.computer, ComputerScreenArea::new);
        }
        if (ModState.AE2 && shouldEnableForAE2()) {
            handlers.addIf(AE2.buttons, AE2ButtonsArea::new);
            handlers.addIf(AE2.cellView, AE2CellViewArea::new);
        }
        if (ModState.TINKER_IO && TINKER_IO.all) {
            handlers.addIf(TINKER_IO.fuelInput, TinkerIOFuelInputMachineArea::new);
            handlers.addIf(TINKER_IO.smartOutput, TinkerIOSmartOutputArea::new);
        }
        if (ModState.BLUE_SKIES) {
            handlers.addIf(BLUE_SKIES.tabs, BlueSkiesTabArea::new);
        }
        if (ModState.CRAFTING_TWEAKS) {
            handlers.addIf(CRAFTING_TWEAKS.buttons, CraftingTweaksButtonArea::new);
        }
        if (ModState.TRINKETS_AND_BAUBLES) {
            handlers.addIf(TRINKETS_AND_BAUBLES.buttons,TrinketGuiButtonArea::new);
            handlers.addIf(TRINKETS_AND_BAUBLES.slots, TrinketGuiArea::new);
        }
        if (ModState.AE2WT_LIB) {
            handlers.addIf(AE2WTLIB.buttons, AE2WTLibButtonsArea::new);
            handlers.addIf(AE2WTLIB.wirelessCraftingTerminal, WirelessCraftingAdditionalArea::new);
        }
        if (ModState.DEEP_MOD_LEARNING) {
            handlers.addIf(DEEP_MOB_LEARNING.buttons, DMLRedstoneModeButtonArea::new);
            handlers.addIf(DEEP_MOB_LEARNING.simulationChamber, SimulationChamberArea::new);
        }
    }

    private static boolean shouldEnableForAE2() {
        val ae2 = Loader.instance().getIndexedModList().get("appliedenergistics2");
        if (ae2 == null) {
            return false;
        }
        if (AE2.detectAE2UEL && ae2.getVersion().startsWith("v")) {
            //AE2-UEL installed
            return false;
        }
        return AE2.all;
    }

    @AllArgsConstructor
    public static class GuiHandlersRegistryHelper {
        private final IModRegistry registry;

        public void add(@Nonnull IAdvancedGuiHandler<?>... handlers) {
            registry.addAdvancedGuiHandlers(handlers);
        }

        public void addIf(boolean condition, @Nonnull Supplier<IAdvancedGuiHandler<?>> handler) {
            if (condition) {
                add(handler.get());
            }
        }
    }
}
