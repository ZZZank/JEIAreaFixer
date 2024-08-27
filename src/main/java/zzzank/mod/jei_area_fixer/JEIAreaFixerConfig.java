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
@Config.RequiresMcRestart
public class JEIAreaFixerConfig {

    @Config.Comment("does not require mc restart")
    public static boolean debug$print = false;
    @Config.Ignore
    public static boolean debug$drawing = false;

    public static boolean General$Buttons = true;

    public static boolean XNet$All = true;
    public static boolean XNet$Controller = true;
    public static boolean XNet$Router = true;

    public static boolean RFTools$All = true;
    public static boolean RFTools$ModularStorage = true;
    public static boolean RFTools$StorageScanner = true;

    public static boolean GamblingStyle$All = true;

    @Config.Comment("For mods made by OpenMods, e.g. OpenBlocks")
    public static boolean OpenMods$All = true;

    public static boolean SmelteryIO$All = true;
    public static boolean SmelteryIO$FuelController = true;
    public static boolean SmelteryIO$CastingMachine = true;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent event) {
        if (!Tags.MOD_ID.equals(event.getModID())) {
            return;
        }
        ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
    }
}
