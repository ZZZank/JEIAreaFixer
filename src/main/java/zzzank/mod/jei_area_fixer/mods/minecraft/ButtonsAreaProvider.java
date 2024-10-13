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
public abstract class ButtonsAreaProvider<T extends GuiButton, G extends GuiContainer>
    extends AbstractJEIAreaProvider<G> {

    private final ButtonIndex<T> index;

    public ButtonsAreaProvider(@Nonnull ButtonIndex<T> index, @Nonnull Class<G> type) {
        super(type);
        this.index = Objects.requireNonNull(index);
    }

    @Nullable
    @Override
    public final List<Rectangle> getExtraAreas(@Nonnull G gui) {
        val cache = ((ButtonsCacheHolder) gui).jaf$cacheIfAbsent(index);
        return cache.isEmpty() ? null : buttonsToAreas(cache, gui);
    }

    @Nullable
    protected abstract List<Rectangle> buttonsToAreas(@Nonnull List<T> buttons, @Nonnull G gui);
}
