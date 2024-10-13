package zzzank.mod.jei_area_fixer.mods.minecraft;

import lombok.val;
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

    public ButtonsAreaProvider(ButtonIndex<T> index) {
        super(GuiContainer.class);
        this.index = Objects.requireNonNull(index);
    }

    @Nullable
    @Override
    public final List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        val cacheHolder = ((ButtonsCacheHolder) gui);
        val cache = cacheHolder.jaf$cacheIfAbsent(index);
        return cache.isEmpty() ? null : buttonsToAreas(cache, gui);
    }

    @Nullable
    protected abstract List<Rectangle> buttonsToAreas(@Nonnull List<T> buttons, @Nonnull GuiContainer gui);
}
