package zzzank.mod.jei_area_fixer;

import mezz.jei.api.gui.IAdvancedGuiHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.debug.JEIAreaFixerDebug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public abstract class AbstractJEIAreaProvider<T extends GuiContainer> implements IAdvancedGuiHandler<T> {

    @Override
    @Nonnull
    public final Class<T> getGuiContainerClass() {
        return getTarget();
    }

    @Nullable
    @Override
    public final List<Rectangle> getGuiExtraAreas(@Nonnull T gui) {
        final List<Rectangle> areas = getExclusionAreas(gui);
        JEIAreaFixerDebug.accept(getTarget(), areas);
        return areas;
    }

    @Nonnull
    protected abstract Class<T> getTarget();

    @Nullable
    protected abstract List<Rectangle> getExclusionAreas(@Nonnull T gui);

    @SuppressWarnings("unchecked")
    protected final <T_> Class<T_> cast(Class<?> c) {
        return (Class<T_>) c;
    }
}
