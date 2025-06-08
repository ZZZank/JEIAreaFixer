package zzzank.mod.jei_area_fixer.mods.minecraft;

import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public abstract class ButtonsAreaProvider<T extends GuiButton, G extends GuiContainer>
    extends AbstractJEIAreaProvider<G> {

    protected abstract ButtonIndex<T> getButtonIndex();

    @Nullable
    @Override
    protected final List<Rectangle> getExclusionAreas(@Nonnull G gui) {
        val cache = ((ButtonsCacheHolder) gui).jaf$cacheIfAbsent(getButtonIndex());
        return cache.isEmpty() ? null : buttonsToAreas(cache, gui);
    }

    @Nullable
    protected abstract List<Rectangle> buttonsToAreas(@Nonnull List<T> buttons, @Nonnull G gui);
}
