package zzzank.mod.jei_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean X_NET = loaded("xnet");
    boolean RF_TOOLS = loaded("rftools");
    boolean GAMBLING_STYLE = loaded("gamblingstyle");
    boolean OPEN_MODS_LIB = loaded("openmods");
    boolean SMELTERY_IO = loaded("mctsmelteryio");
    boolean RESKILLABLE = loaded("reskillable");

    static boolean loaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
