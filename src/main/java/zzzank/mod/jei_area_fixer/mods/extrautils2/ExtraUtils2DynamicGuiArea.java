package zzzank.mod.jei_area_fixer.mods.extrautils2;

import com.rwtema.extrautils2.gui.backend.DynamicGui;
import com.rwtema.extrautils2.gui.backend.IWidget;
import lombok.AllArgsConstructor;
import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
public class ExtraUtils2DynamicGuiArea extends AbstractJEIAreaProvider<DynamicGui> {
    @Nonnull
    @Override
    protected Class<DynamicGui> getTarget() {
        return DynamicGui.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull DynamicGui gui) {
        val processor = new Widget2Area(gui);
        return gui.container.getWidgets()
            .stream()
            .filter(processor)
            .map(processor)
            .collect(Collectors.toList());
    }

    @AllArgsConstructor
    public static final class Widget2Area implements Predicate<IWidget>, Function<IWidget, Rectangle> {
        private final GuiContainer gui;

        @Override
        public boolean test(IWidget widget) {
            return widget.getX() < 0
                || widget.getX() + widget.getW() > gui.getXSize();
        }

        @Override
        public Rectangle apply(IWidget widget) {
            return new Rectangle(
                gui.getGuiLeft() + widget.getX(),
                gui.getGuiTop() + widget.getY(),
                widget.getW(),
                widget.getH()
            );
        }
    }
}
