package zzzank.mod.jei_area_fixer.mods.minecraft;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * @author ZZZank
 */
public interface ButtonsCacheHolder {

    @Nonnull
    Map<ButtonIndex<?>, List<GuiButton>> jaf$getCache();

    @Nonnull
    List<GuiButton> jaf$getButtonList();

    @SuppressWarnings("unchecked")
    default <T extends GuiButton> List<T> jaf$cacheIfAbsent(ButtonIndex<T> index) {
        return (List<T>) this.jaf$getCache()
            .computeIfAbsent(
                index,
                (buttonIndex) -> this.jaf$getButtonList()
                    .stream()
                    .filter(buttonIndex.filter)
                    .filter(b -> AreaFilter.notInGui((GuiContainer) this, b)
                        && (!JEIAreaFixerConfig.GENERAL.preventShiftingBookmark || AreaFilter.notShiftingBookmark(b)))
                    .collect(ImmutableList.toImmutableList())
            );
    }
}
