package zzzank.mod.jei_area_fixer.mixin.xnet;

import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.widgets.WidgetList;
import mcjty.xnet.blocks.controller.TileEntityController;
import mcjty.xnet.blocks.controller.gui.GuiController;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(GuiController.class)
public abstract class MixinGuiController extends GenericGuiContainer<TileEntityController> implements JEIAreaProvider {

    @Shadow(remap = false)
    private WidgetList connectorList;

    @Nullable
    @Override
    public List<Rectangle> jei_area_fixer$getAreas() {
        return JEIAreaFixer.nullableWrap(this.connectorList.getBounds());
    }

    private MixinGuiController() {
        super(null, null, null, null, 0, null);
    }
}
