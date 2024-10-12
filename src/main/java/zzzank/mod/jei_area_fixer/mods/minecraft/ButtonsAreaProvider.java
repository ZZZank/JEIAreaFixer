package zzzank.mod.jei_area_fixer.mods.minecraft;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * @author ZZZank
 */
public abstract class ButtonsAreaProvider<T extends GuiButton> extends AbstractJEIAreaProvider<GuiContainer> {
    private final ButtonIndex<T> index;

    protected ButtonsAreaProvider(ButtonIndex<T> index) {
        super(GuiContainer.class);
        this.index = Objects.requireNonNull(index);
    }

    @Nullable
    @Override
    public final List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        var cacheHolder = ((ButtonsCacheHolder) gui);
        var cache = cacheHolder.jaf$cacheIfAbsent(index.index, index.typeProvider.get());
        return cache.isEmpty() ? null : buttonsToAreas(cache);
    }

    @Nullable
    protected abstract List<Rectangle> buttonsToAreas(@Nonnull ImmutableList<T> buttons);
}
