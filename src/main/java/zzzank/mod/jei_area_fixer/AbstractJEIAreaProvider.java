package zzzank.mod.jei_area_fixer;

import mezz.jei.api.gui.IAdvancedGuiHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.debug.JEIAreaFixerDebug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.Objects;

/**
 * @author ZZZank
 */
public abstract class AbstractJEIAreaProvider<T extends GuiContainer> implements IAdvancedGuiHandler<T> {

    private final Class<T> target;

    public AbstractJEIAreaProvider(@Nonnull Class<T> target) {
        this.target = Objects.requireNonNull(target);
    }

    @Override
    @Nonnull
    public final Class<T> getGuiContainerClass() {
        return target;
    }

    @Deprecated
    @Nullable
    @Override
    public final List<Rectangle> getGuiExtraAreas(@Nonnull T gui) {
        final List<Rectangle> areas = getExtraAreas(gui);
        JEIAreaFixerDebug.accept(target, areas);
        return areas;
    }

    @Nullable
    public abstract List<Rectangle> getExtraAreas(@Nonnull T gui);
}
