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

    @Config.Comment("print changed bounds to log every few seconds")
    public static boolean debug$print = false;
    @Config.Ignore
    public static boolean debug$drawing = false;

    @Config.RequiresMcRestart
    @Config.Comment("Disabled by default because many, many mod devs are not drawing buttons in a standard way")
    public static boolean General$Buttons = false;

    @Config.RequiresMcRestart
    public static boolean Cyclic$ExtendedInventory = true;

    @Config.RequiresMcRestart
    public static boolean Forestry$Tabs = true;

    @Config.RequiresMcRestart
    public static boolean XNet$All = true;
    @Config.RequiresMcRestart
    public static boolean XNet$Controller = true;
    @Config.RequiresMcRestart
    public static boolean XNet$Router = true;

    @Config.RequiresMcRestart
    public static boolean RFTools$All = true;
    @Config.RequiresMcRestart
    public static boolean RFTools$ModularStorage = true;
    @Config.RequiresMcRestart
    public static boolean RFTools$StorageScanner = true;

    @Config.RequiresMcRestart
    public static boolean GamblingStyle$All = true;

    @Config.RequiresMcRestart
    @Config.Comment("For mods made by OpenMods, e.g. OpenBlocks")
    public static boolean OpenMods$All = true;

    @Config.RequiresMcRestart
    public static boolean Quark$ChestButtons = true;

    @Config.RequiresMcRestart
    public static boolean Reskillable$Tabs = true;

    @Config.RequiresMcRestart
    public static boolean SmelteryIO$All = true;
    @Config.RequiresMcRestart
    public static boolean SmelteryIO$FuelController = true;
    @Config.RequiresMcRestart
    public static boolean SmelteryIO$CastingMachine = true;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent event) {
        if (!Tags.MOD_ID.equals(event.getModID())) {
            return;
        }
        ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
    }
}
