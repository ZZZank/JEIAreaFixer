package zzzank.mod.jei_area_fixer.mods.minecraft;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import lombok.val;
import net.minecraft.client.gui.GuiButton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public interface ButtonsCacheHolder {

    Int2ObjectMap<List<GuiButton>> jeiAreaFixer$getCache();

    List<GuiButton> jeiAreaFixer$getButtonList();

    @SuppressWarnings("unchecked")
    default <T extends GuiButton> List<T> jaf$cacheIfAbsent(ButtonIndex<T> index) {
        return (List<T>) this.jeiAreaFixer$getCache()
            .computeIfAbsent(
                index.index,
                k -> {
                    val list = new ArrayList<GuiButton>();
                    for (val guiButton : this.jeiAreaFixer$getButtonList()) {
                        if (index.filter.test(guiButton)) {
                            list.add(guiButton);
                        }
                    }
                    return list;
                }
            );
    }
}
