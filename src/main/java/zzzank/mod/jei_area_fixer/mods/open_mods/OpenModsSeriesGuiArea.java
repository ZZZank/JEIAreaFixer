package zzzank.mod.jei_area_fixer.mods.open_mods;

import lombok.val;
import openmods.gui.ComponentGui;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mixin.openmods.AccessBaseComposite;
import zzzank.mod.jei_area_fixer.mixin.openmods.AccessComponentGui;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class OpenModsSeriesGuiArea extends AbstractJEIAreaProvider<ComponentGui> {

    @Nonnull
    @Override
    protected Class<ComponentGui> getTarget() {
        return ComponentGui.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull ComponentGui gui) {
        val root = ((AccessComponentGui) gui).jaf$root();
        val components = ((AccessBaseComposite) root).jaf$components();
        val areas = new ArrayList<Rectangle>(components.size());
        for (val component : components) {
            areas.add(new Rectangle(
                component.getX() + gui.getGuiLeft(),
                component.getY() + gui.getGuiTop(),
                component.getWidth(),
                component.getHeight()
            ));
        }
        return areas;
    }
}
