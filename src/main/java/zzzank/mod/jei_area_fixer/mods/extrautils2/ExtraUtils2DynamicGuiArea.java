package zzzank.mod.jei_area_fixer.mods.extrautils2;

import com.rwtema.extrautils2.gui.backend.DynamicGui;
import com.rwtema.extrautils2.gui.backend.IWidget;
import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
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
        val widgets = gui.container.getWidgets();
        return widgets.stream()
            .filter(w -> notInGui(gui, w))
            .map(ExtraUtils2DynamicGuiArea::toRect)
            .collect(Collectors.toList());
    }

    public static boolean notInGui(@Nonnull GuiContainer gui, @Nonnull IWidget button) {
        return button.getX() < gui.getGuiLeft()
            || button.getX() + button.getW() > gui.getGuiLeft() + gui.getXSize();
    }

    public static Rectangle toRect(@Nonnull IWidget widget) {
        return new Rectangle(widget.getX(), widget.getY(), widget.getW(), widget.getH());
    }
}
