package zzzank.mod.bookmark_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean X_NET = loaded("xnet");
    boolean RF_TOOLS = loaded("rftools");
    boolean GAMBLING_STYLE = loaded("gamblingstyle");

    static boolean loaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
