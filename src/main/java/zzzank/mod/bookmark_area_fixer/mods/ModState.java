package zzzank.mod.bookmark_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean X_NET = modloaded("xnet");
    boolean RF_TOOLS = modloaded("rftools");

    static boolean modloaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
