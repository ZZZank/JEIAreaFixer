package zzzank.mod.bookmark_area_fixer;

import net.minecraftforge.common.config.Config;

/**
 * @author ZZZank
 */
@Config(modid = Tags.MOD_ID, category = "client")
@Config.RequiresMcRestart
public class BookmarkAreaFixerConfig {

    public static boolean enableForXNet = true;

    public static boolean enableForRFTools = true;
}
