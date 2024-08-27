package zzzank.mod.jei_area_fixer.mods.reskillable;

import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class ReskillableTabArea extends AbstractJEIAreaProvider<GuiContainer> {

    public ReskillableTabArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        return  ((ReskillableAreasProvider) gui).jei_area_fixer$getReskillableAreas();
    }
}
