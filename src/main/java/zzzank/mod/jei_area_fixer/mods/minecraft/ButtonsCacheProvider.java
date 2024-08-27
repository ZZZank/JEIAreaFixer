package zzzank.mod.jei_area_fixer.mods.minecraft;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.gui.GuiButton;

import java.util.List;

/**
 * @author ZZZank
 */
public interface ButtonsCacheProvider {

    Int2ObjectMap<List<GuiButton>> jeiAreaFixer$getCache();

    List<GuiButton> jeiAreaFixer$getButtonList();
}
