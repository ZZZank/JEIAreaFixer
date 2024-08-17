package zzzank.mod.jei_area_fixer;

import net.minecraftforge.common.config.Config;

/**
 * @author ZZZank
 */
@Config(modid = Tags.MOD_ID, category = "client")
@Config.RequiresMcRestart
public class JEIAreaFixerConfig {

    public static boolean enableForXNet = true;

    public static boolean enableForRFTools = true;

    public static boolean enableForGamblingStyle = true;

    public static boolean enableForOpenMods = true;
}
