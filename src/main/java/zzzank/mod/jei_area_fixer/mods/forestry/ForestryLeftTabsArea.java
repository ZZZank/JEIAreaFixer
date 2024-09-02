package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class ForestryLeftTabsArea extends AbstractJEIAreaProvider<GuiForestry> {

    public ForestryLeftTabsArea() {
        super(GuiForestry.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiForestry gui) {
        //?
        return gui.getExtraGuiAreas();
    }
}
