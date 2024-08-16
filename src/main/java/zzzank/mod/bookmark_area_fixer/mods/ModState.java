package zzzank.mod.bookmark_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean XNET = loaded("xnet");
    boolean RFTOOLS = loaded("rftools");

    static boolean loaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
