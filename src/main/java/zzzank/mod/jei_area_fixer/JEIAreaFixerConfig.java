package zzzank.mod.jei_area_fixer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author ZZZank
 */
@Config(modid = Tags.MOD_ID, category = "client")
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Tags.MOD_ID)
public class JEIAreaFixerConfig {

    public static final _Debug DEBUG = new _Debug();
    @Config.RequiresMcRestart
    public static final _General GENERAL = new _General();

    @Config.RequiresMcRestart
    public static final _AE2 AE2 = new _AE2();
    @Config.RequiresMcRestart
    public static final _ComputerCraft COMPUTER_CRAFT = new _ComputerCraft();
    @Config.RequiresMcRestart
    public static final _McjtyLib MCJTY_LIB = new _McjtyLib();
    @Config.RequiresMcRestart
    public static final _Cyclic CYCLIC = new _Cyclic();
    @Config.RequiresMcRestart
    public static final _Forestry FORESTRY = new _Forestry();
    @Config.RequiresMcRestart
    public static final _RFTools RF_TOOLS = new _RFTools();
    @Config.RequiresMcRestart
    public static final _GamblingStyle GAMBLING_STYLE = new _GamblingStyle();
    @Config.RequiresMcRestart
    public static final _OpenMods OPEN_MODS = new _OpenMods();
    @Config.RequiresMcRestart
    public static final _Quark QUARK = new _Quark();
    @Config.RequiresMcRestart
    public static final _Reskillable RESKILLABLE = new _Reskillable();
    @Config.RequiresMcRestart
    public static final _SmelteryIO SMELTERY_IO = new _SmelteryIO();
    @Config.RequiresMcRestart
    public static final _TinkerIO TINKER_IO = new _TinkerIO();
    @Config.RequiresMcRestart
    public static final _BlueSkies BLUE_SKIES = new _BlueSkies();
    @Config.RequiresMcRestart
    public static final _CraftingTweaks CRAFTING_TWEAKS = new _CraftingTweaks();
    @Config.RequiresMcRestart
    public static final _TrinketsAndBaubles TRINKETS_AND_BAUBLES = new _TrinketsAndBaubles();
    @Config.RequiresMcRestart
    public static final _AE2WTLib AE2WTLIB = new _AE2WTLib();
    @Config.RequiresMcRestart
    public static final _DeepMobLearning DEEP_MOB_LEARNING = new _DeepMobLearning();

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent event) {
        if (!Tags.MOD_ID.equals(event.getModID())) {
            return;
        }
        ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Debug {
        public boolean print = false;
        public boolean draw = false;
        public boolean drawAll = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _AE2 {
        public boolean all = true;
        public boolean detectAE2UEL = true;
        public boolean buttons = true;
        public boolean cellView = false;
        public boolean preventShiftingBookmark = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _ComputerCraft {
        public boolean computer = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _General {
        public boolean aggressiveButtonCapture = false;
        public boolean preventShiftingBookmark = false;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _McjtyLib {
        public boolean all = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Cyclic {
        public boolean extendedInventory = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Forestry {
        public boolean tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _RFTools {
        public boolean all = true;
        public boolean modularStorage = true;
        public boolean storageScanner = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _GamblingStyle {
        public boolean all = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _OpenMods {
        public boolean all = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Quark {
        public boolean chestButtons = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Reskillable {
        public boolean tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _SmelteryIO {
        public boolean all = true;
        public boolean fuelController = true;
        public boolean castingMachine = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _TinkerIO {
        public boolean all = true;
        public boolean smartOutput = true;
        public boolean fuelInput = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _BlueSkies {
        public boolean tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _CraftingTweaks {
        public boolean buttons = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _TrinketsAndBaubles {
        public boolean buttons = true;
        public boolean slots = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _AE2WTLib {
        public boolean buttons = true;
        public boolean wirelessCraftingTerminal = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _DeepMobLearning {
        public boolean buttons = true;
        public boolean simulationChamber = true;
    }
}
