package zzzank.mod.jei_area_fixer;

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

    @Config.Comment("print changed bounds to log every few seconds")
    public static boolean debug$print = false;
    @Config.Comment("Draw areas provided by JEI Area Fixer onto the screen")
    public static boolean debug$drawing = false;

    @Config.RequiresMcRestart
    @Config.Comment("Disabled by default because many, many mod devs are not drawing buttons in a standard way")
    public static boolean General$Buttons = false;

    @Config.RequiresMcRestart
    @Config.Comment("General support for mods made by mcjty, mostly affecting XNet")
    public static boolean McjtyLib$General = true;

    @Config.RequiresMcRestart
    @Config.Comment("Support for armor slots in extended player inventory")
    public static boolean Cyclic$ExtendedInventory = true;

    @Config.RequiresMcRestart
    @Config.Comment("Support for tabs in Forestry machines")
    public static boolean Forestry$Tabs = true;

    @Config.RequiresMcRestart
    @Config.Comment("Global switch for RFTools support, disabling this will disable all RFTools specific patches")
    public static boolean RFTools$All = true;
    @Config.RequiresMcRestart
    @Config.Comment("Support crafting girds in Modular Storage")
    public static boolean RFTools$ModularStorage = true;
    @Config.RequiresMcRestart
    @Config.Comment("Support crafting girds in Storage Scanner")
    public static boolean RFTools$StorageScanner = true;

    @Config.RequiresMcRestart
    @Config.Comment("Support for Gambling Style")
    public static boolean GamblingStyle$All = true;

    @Config.RequiresMcRestart
    @Config.Comment("For mods made by OpenMods, e.g. OpenBlocks")
    public static boolean OpenMods$All = true;

    @Config.RequiresMcRestart
    @Config.Comment("Support for Quark Chest Buttons")
    public static boolean Quark$ChestButtons = true;

    @Config.RequiresMcRestart
    @Config.Comment("Support for Reskillable player inventory tabs")
    public static boolean Reskillable$Tabs = true;

    @Config.RequiresMcRestart
    @Config.Comment("Global switch for Smeltery IO support, disabling this will disable all Smeltery IO specific patches")
    public static boolean SmelteryIO$All = true;
    @Config.RequiresMcRestart
    @Config.Comment("Support for Fuel Controller")
    public static boolean SmelteryIO$FuelController = true;
    @Config.RequiresMcRestart
    @Config.Comment("Support for Casting Machine")
    public static boolean SmelteryIO$CastingMachine = true;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent event) {
        if (!Tags.MOD_ID.equals(event.getModID())) {
            return;
        }
        ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
    }
}
