package zzzank.mod.jei_area_fixer.mods.openmods;

import mezz.jei.api.gui.IAdvancedGuiHandler;
import openmods.gui.ComponentGui;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class OpenModsSeriesGuiArea implements IAdvancedGuiHandler<ComponentGui> {

    @Override
    @Nonnull
    public Class<ComponentGui> getGuiContainerClass() {
        return ComponentGui.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(@Nonnull ComponentGui guiContainer) {
        var root = ((ComponentGuiAccessor) guiContainer).get$root();
        var components = ((BaseCompositeAccessor) root).get$components();
        var areas = new ArrayList<Rectangle>(components.size());
        for (var component : components) {
            areas.add(new Rectangle(
                component.getX() + guiContainer.getGuiLeft(),
                component.getY() + guiContainer.getGuiTop(),
                component.getWidth(),
                component.getHeight()
            ));
        }
        return areas;
    }
}