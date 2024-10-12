package zzzank.mod.jei_area_fixer.mods;

import net.minecraftforge.fml.common.Loader;

/**
 * @author ZZZank
 */
public interface ModState {

    boolean RF_TOOLS = loaded("rftools");
    boolean GAMBLING_STYLE = loaded("gamblingstyle");
    boolean OPEN_MODS_LIB = loaded("openmods");
    boolean SMELTERY_IO = loaded("mctsmelteryio");
    boolean RESKILLABLE = loaded("reskillable");
    boolean QUARK = loaded("quark");
    boolean FORESTRY = loaded("forestry");
    boolean CYCLIC = loaded("cyclicmagic");
    boolean MCJTY_LIB = loaded("mcjtylib_ng");
    boolean OPEN_COMPUTERS = loaded("opencomputers");
    /**
     * aka CC: Tweaked
     */
    boolean COMPUTER_CRAFT = loaded("computercraft");
    boolean AE2 = loaded("appliedenergistics2");
    boolean TINKER_IO = loaded("tinker_io");
    boolean BLUE_SKIES = loaded("blue_skies");
    boolean CRAFTING_TWEAKS = loaded("craftingtweaks");
    boolean TRINKETS_AND_BAUBLES = loaded("xat");
    boolean BAUBLES = loaded("baubles");

    static boolean loaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}
