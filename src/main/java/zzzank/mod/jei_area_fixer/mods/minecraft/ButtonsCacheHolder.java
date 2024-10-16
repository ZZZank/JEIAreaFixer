package zzzank.mod.jei_area_fixer.mods.minecraft;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public interface ButtonsCacheHolder {

    default GuiContainer jaf$self() {
        return (GuiContainer) this;
    }

    Int2ObjectMap<List<GuiButton>> jaf$getCache();

    List<GuiButton> jaf$getButtonList();

    @SuppressWarnings("unchecked")
    default <T extends GuiButton> List<T> jaf$cacheIfAbsent(ButtonIndex<T> index) {
        return (List<T>) this.jaf$getCache()
            .computeIfAbsent(
                index.index,
                k -> {
                    val list = new ArrayList<GuiButton>();
                    for (val button : this.jaf$getButtonList()) {
                        if (index.filter.test(button)
                            && AreaFilter.notInGui(jaf$self(), button)
                            && (!JEIAreaFixerConfig.GENERAL.preventShiftingBookmark || AreaFilter.notShiftingBookmark(button))
                        ) {
                            list.add(button);
                        }
                    }
                    return list;
                }
            );
    }
}
