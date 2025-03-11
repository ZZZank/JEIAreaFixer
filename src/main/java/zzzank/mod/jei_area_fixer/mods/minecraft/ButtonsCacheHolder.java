package zzzank.mod.jei_area_fixer.mods.minecraft;

import com.google.common.collect.ImmutableList;
import com.sun.istack.internal.NotNull;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import java.util.List;
import java.util.Map;

/**
 * @author ZZZank
 */
public interface ButtonsCacheHolder {

    default GuiContainer jaf$self() {
        return (GuiContainer) this;
    }

    @NotNull
    Map<Integer, List<GuiButton>> jaf$getCache();

    @NotNull
    List<GuiButton> jaf$getButtonList();

    @SuppressWarnings("unchecked")
    default <T extends GuiButton> List<T> jaf$cacheIfAbsent(ButtonIndex<T> index) {
        return (List<T>) this.jaf$getCache()
            .computeIfAbsent(
                index.index,
                (k) -> this.jaf$getButtonList()
                    .stream()
                    .filter(index.filter)
                    .filter(b -> AreaFilter.notInGui(jaf$self(), b)
                        && (!JEIAreaFixerConfig.GENERAL.preventShiftingBookmark || AreaFilter.notShiftingBookmark(b)))
                    .collect(ImmutableList.toImmutableList())
            );
    }
}
