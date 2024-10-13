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
import zzzank.mod.jei_area_fixer.mods.appliedenergistics2.AE2ButtonsArea;
import zzzank.mod.jei_area_fixer.mods.appliedenergistics2.AE2CellViewArea;
import zzzank.mod.jei_area_fixer.mods.blue_skies.BlueSkiesTabArea;
import zzzank.mod.jei_area_fixer.mods.computercraft.ComputerScreenArea;
import zzzank.mod.jei_area_fixer.mods.craftingtweaks.CraftingTweaksButtonArea;
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
import zzzank.mod.jei_area_fixer.mods.xat.TrinketGuiArea;
import zzzank.mod.jei_area_fixer.mods.xat.TrinketGuiButtonArea;

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
        if (General$Buttons) {
            val buttonsArea = new GeneralButtonsArea();
            handlers.add(buttonsArea);
            MinecraftForge.EVENT_BUS.register(buttonsArea);
        }
        if (ModState.RF_TOOLS && RFTools$All) {
            handlers.addIf(RFTools$ModularStorage, ModularStorageArea::new);
            handlers.addIf(RFTools$StorageScanner, StorageScannerArea::new);
        }
        if (ModState.GAMBLING_STYLE && GamblingStyle$All) {
            handlers.add(new GuiVillagerArea());
        }
        if (ModState.OPEN_MODS_LIB && OpenMods$All) {
            handlers.add(new OpenModsSeriesGuiArea());
        }
        if (ModState.SMELTERY_IO && SmelteryIO$All) {
            handlers.addIf(SmelteryIO$CastingMachine, FuelControllerArea::new);
            handlers.addIf(SmelteryIO$FuelController, CastingMachineArea::new);
        }
        if (ModState.RESKILLABLE) {
            handlers.addIf(Reskillable$Tabs, ReskillableTabArea::new);
        }
        if (ModState.QUARK) {
            handlers.addIf(Quark$ChestButtons, ChestButtonsArea::new);
        }
        if (ModState.FORESTRY) {
            handlers.addIf(Forestry$Tabs, ForestryLedgersArea::new);
        }
        if (ModState.CYCLIC) {
            handlers.addIf(Cyclic$ExtendedInventory, ExtendedArmorInventoryArea::new);
        }
        if (ModState.MCJTY_LIB) {
            handlers.addIf(McjtyLib$General, GenericGuiContainerArea::new);
        }
        if (ModState.COMPUTER_CRAFT) {
            handlers.addIf(ComputerCraft$Computer, ComputerScreenArea::new);
        }
        if (ModState.AE2 && shouldEnableForAE2()) {
            handlers.addIf(AE2$Buttons, AE2ButtonsArea::new);
            handlers.addIf(AE2$CellView, AE2CellViewArea::new);
        }
        if (ModState.TINKER_IO && TinkerIO$All) {
            handlers.addIf(TinkerIO$FuelInput, TinkerIOFuelInputMachineArea::new);
            handlers.addIf(TinkerIO$SmartOutput, TinkerIOSmartOutputArea::new);
        }
        if (ModState.BLUE_SKIES) {
            handlers.addIf(BlueSkies$Tabs, BlueSkiesTabArea::new);
        }
        if (ModState.CRAFTING_TWEAKS) {
            handlers.addIf(CraftingTweaks$Buttons, CraftingTweaksButtonArea::new);
        }
        if (ModState.TRINKETS_AND_BAUBLES) {
            handlers.addIf(TrinketsAndBaubles$Buttons,TrinketGuiButtonArea::new);
            handlers.addIf(TrinketsAndBaubles$Slots, TrinketGuiArea::new);
        }
        if (ModState.AE2WT_LIB) {
            handlers.addIf(AE2WTLib$Buttons, AE2WTLibButtonsArea::new);
            handlers.addIf(AE2WTLib$WirelessCraftingTerminal, WirelessCraftingAdditionalArea::new);
        }
    }

    private static boolean shouldEnableForAE2() {
        val ae2 = Loader.instance().getIndexedModList().get("appliedenergistics2");
        if (ae2 == null) {
            return false;
        }
        if (AE2$DetectAE2UEL && ae2.getVersion().startsWith("v")) {
            //AE2-UEL installed
            return false;
        }
        return AE2$All;
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
