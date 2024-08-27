package zzzank.mod.jei_area_fixer.mods.quark;

import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @see zzzank.mod.jei_area_fixer.mixin.minecraft.MixinGuiContainerForQuark
 * @author ZZZank
 */
public class ChestButtonsArea extends AbstractJEIAreaProvider<GuiContainer> {

    public ChestButtonsArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        return ((QuarkAreasProvider) gui).jei_area_fixer$getQuarkAreas();
    }
}
