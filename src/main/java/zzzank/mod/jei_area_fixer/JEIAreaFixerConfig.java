package zzzank.mod.jei_area_fixer;

import net.minecraftforge.common.config.Config;

/**
 * @author ZZZank
 */
@Config(modid = Tags.MOD_ID, category = "client")
@Config.RequiresMcRestart
public class JEIAreaFixerConfig {

    public static boolean debug$print = false;
    public static boolean debug$drawing = false;

    public static boolean XNet$All = true;
    public static boolean XNet$Controller = true;
    public static boolean XNet$Router = true;

    public static boolean RFTools$All = true;
    public static boolean RFTools$ModularStorage = true;
    public static boolean RFTools$StorageScanner = true;

    public static boolean GamblingStyle$All = true;

    public static boolean OpenMods$All = true;

    public static boolean SmelteryIO$All = true;
    public static boolean SmelteryIO$FuelController = true;
    public static boolean SmelteryIO$CastingMachine = true;
}
