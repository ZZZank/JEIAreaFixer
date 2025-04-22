package zzzank.mod.jei_area_fixer.mods.mrtjpcore;

import lombok.val;
import mrtjp.core.gui.NodeGui;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class NodeGuiArea extends AbstractJEIAreaProvider<NodeGui> {
    @Nonnull
    @Override
    protected Class<NodeGui> getTarget() {
        return NodeGui.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull NodeGui gui) {
        val areas = new ArrayList<Rectangle>();
        val itr = gui.children().iterator();
        while (itr.hasNext()) {
            val node = itr.next();
            val frame = node.frame();
            areas.add(new Rectangle(
                gui.getGuiLeft() + frame.x(),
                gui.getGuiTop() + frame.y(),
                frame.width(),
                frame.height()
            ));
        }
        return areas;
    }
}
