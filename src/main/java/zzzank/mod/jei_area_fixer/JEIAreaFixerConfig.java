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

    private static final String LANG_PREFIX = "jei_area_fixer.config.";
    public static final _Debug DEBUG = new _Debug();
    public static final _General GENERAL = new _General();

    public static final _AE2 AE2 = new _AE2();
    public static final _ComputerCraft COMPUTER_CRAFT = new _ComputerCraft();
    public static final _McjtyLib MCJTY_LIB = new _McjtyLib();
    public static final _Cyclic CYCLIC = new _Cyclic();
    public static final _Forestry FORESTRY = new _Forestry();
    public static final _RFTools RF_TOOLS = new _RFTools();
    public static final _GamblingStyle GAMBLING_STYLE = new _GamblingStyle();
    public static final _OpenMods OPEN_MODS = new _OpenMods();
    public static final _Quark QUARK = new _Quark();
    public static final _Reskillable RESKILLABLE = new _Reskillable();
    public static final _SmelteryIO SMELTERY_IO = new _SmelteryIO();
    public static final _TinkerIO TINKER_IO = new _TinkerIO();
    public static final _BlueSkies BLUE_SKIES = new _BlueSkies();
    public static final _CraftingTweaks CRAFTING_TWEAKS = new _CraftingTweaks();
    public static final _TrinketsAndBaubles TRINKETS_AND_BAUBLES = new _TrinketsAndBaubles();
    public static final _AE2WTLib AE2WTLIB = new _AE2WTLib();
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
        @Config.Comment("print changed bounds to log every few seconds")
        public boolean print = false;
        @Config.Comment("Draw areas provided by JEI Area Fixer onto the screen")
        public boolean draw = false;
        @Config.Comment("Draw all exclusion areas posted to JEI onto the screen, requires `drawing` to be `true`")
        public boolean drawAll = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _AE2 {
        @Config.RequiresMcRestart
        @Config.Comment("Global switch for AE2 support, disabling this will disable all AE2 specific patches")
        public boolean all = true;
        @Config.Comment({
            "AE2-UEL has builtin JEI support, so you might want to disable AE2 support when using AE2-UEL, but it's supporting fewer AE GUIs than JEI Area Fixer does",
            "Disable this if you don't want to force-disable AE2 patch when using AE2-UEL"
        })
        public boolean detectAE2UEL = true;
        @Config.RequiresMcRestart
        @Config.Comment({
            "Support for AE2 buttons, usually located at the left side of AE2 GUI",
            "Also noted that you might find some ghost button areas where buttons only show up after installing upgrades, this is a bug, not a feature.",
            "Disable this if you find it annoying"
        })
        public boolean buttons = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for AE2 cell view, located at the upper right side of AE2 terminal")
        public boolean cellView = false;
        @Config.Comment("Try to ignore areas that will make the whole JEI overlay shift")
        public boolean ignoreAreasTooHigh = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _ComputerCraft {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Computer screen")
        public boolean ComputerCraft$Computer = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _General {
        @Config.RequiresMcRestart
        @Config.Comment("Disabled by default because many, many mod devs are not drawing buttons in a standard way")
        public boolean General$Buttons = false;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _McjtyLib {
        @Config.RequiresMcRestart
        @Config.Comment("General support for mods made by mcjty, mostly affecting XNet")
        public boolean McjtyLib$General = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Cyclic {
        @Config.RequiresMcRestart
        @Config.Comment("Support for armor slots in extended player inventory")
        public boolean Cyclic$ExtendedInventory = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Forestry {
        @Config.RequiresMcRestart
        @Config.Comment("Support for tabs in Forestry machines")
        public boolean Forestry$Tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _RFTools {
        @Config.RequiresMcRestart
        @Config.Comment("Global switch for RFTools support, disabling this will disable all RFTools specific patches")
        public boolean RFTools$All = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support crafting girds in Modular Storage")
        public boolean RFTools$ModularStorage = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support crafting girds in Storage Scanner")
        public boolean RFTools$StorageScanner = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _GamblingStyle {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Gambling Style")
        public boolean GamblingStyle$All = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _OpenMods {
        @Config.RequiresMcRestart
        @Config.Comment("For mods made by OpenMods, e.g. OpenBlocks")
        public boolean OpenMods$All = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Quark {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Quark Chest Buttons")
        public boolean Quark$ChestButtons = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _Reskillable {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Reskillable player inventory tabs")
        public boolean Reskillable$Tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _SmelteryIO {
        @Config.RequiresMcRestart
        @Config.Comment("Global switch for Smeltery IO support, disabling this will disable all Smeltery IO specific patches")
        public boolean SmelteryIO$All = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for Fuel Controller")
        public boolean SmelteryIO$FuelController = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for Casting Machine")
        public boolean SmelteryIO$CastingMachine = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _TinkerIO {
        @Config.RequiresMcRestart
        @Config.Comment("Global switch for TinkerIO support, disabling this will disable all TinkerIO specific patches")
        public boolean TinkerIO$All = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for Smart Output")
        public boolean TinkerIO$SmartOutput = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for Fuel Input Machine")
        public boolean TinkerIO$FuelInput = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _BlueSkies {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Blue Skies tabs, usually located at the right side of your inventory")
        public boolean BlueSkies$Tabs = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _CraftingTweaks {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Crafting Tweaks")
        public boolean CraftingTweaks$Buttons = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _TrinketsAndBaubles {
        @Config.RequiresMcRestart
        @Config.Comment("Support for Trinkets And Baubles switch button")
        public boolean TrinketsAndBaubles$Buttons = true;
        @Config.RequiresMcRestart
        @Config.Comment("Support for Trinkets And Baubles trinket gui")
        public boolean TrinketsAndBaubles$Slots = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _AE2WTLib {
        @Config.RequiresMcRestart
        @Config.Comment("Support for AE2WTLib, and its dependents: Wireless Crafting/Pattern/Fluid/Interface Terminal")
        public boolean AE2WTLib$Buttons = true;
        @Config.RequiresMcRestart
        @Config.Comment("Additional support for Wireless Crafting Terminal")
        public boolean AE2WTLib$WirelessCraftingTerminal = true;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class _DeepMobLearning {
        @Config.RequiresMcRestart
        @Config.Comment("Support for redstone mode button in Deep Mob Learning and its forks like Deep Mod Evolution")
        public boolean DeepModLearning$Buttons = true;
        @Config.RequiresMcRestart
        @Config.Comment("Additional support for Simulation Chamber in Deep Mob Learning")
        public boolean DeepModLearning$SimulationChamber = true;
    }
}
