package zzzank.mod.jei_area_fixer.mods.minecraft;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.gui.GuiButton;

import java.util.List;

/**
 * @author ZZZank
 */
public interface ButtonsCacheHolder {

    Int2ObjectMap<List<GuiButton>> jeiAreaFixer$getCache();

    List<GuiButton> jeiAreaFixer$getButtonList();

    @SuppressWarnings("unchecked")
    default <T extends GuiButton> List<T> jeiAreaFixer$computeCacheIfAbsent(int key, Class<T> filter) {
        return (List<T>) this.jeiAreaFixer$getCache()
            .computeIfAbsent(
                key,
                k -> this.jeiAreaFixer$getButtonList()
                    .stream()
                    .filter(filter::isInstance)
                    .collect(ImmutableList.toImmutableList())
            );
    }
}
