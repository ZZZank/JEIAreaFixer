package zzzank.mod.jei_area_fixer.mods.mcjty_lib;

import mcjty.lib.gui.GenericGuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class GenericGuiContainerArea extends AbstractJEIAreaProvider<GenericGuiContainer<?>> {

    @Nonnull
    @Override
    protected Class<GenericGuiContainer<?>> getTarget() {
        return cast(GenericGuiContainer.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GenericGuiContainer<?> gui) {
        return JEIAreaFixer.nullableWrap(gui.getWindow().getToplevel().getBounds());
    }
}
