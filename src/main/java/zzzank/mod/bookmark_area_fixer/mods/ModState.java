package zzzank.mod.bookmark_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean XNET = modloaded("xnet");
    boolean RFTOOLS = modloaded("rftools");

    static boolean modloaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
