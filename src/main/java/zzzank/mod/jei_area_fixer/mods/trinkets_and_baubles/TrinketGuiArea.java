package zzzank.mod.jei_area_fixer.mods.trinkets_and_baubles;

import xzeroair.trinkets.client.gui.TrinketGui;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class TrinketGuiArea extends AbstractJEIAreaProvider<TrinketGui> {

    @Nonnull
    @Override
    protected Class<TrinketGui> getTarget() {
        return TrinketGui.class;
    }

    /**
     * @see TrinketGui#renderTrinketInventory(int, int)
     */
    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull TrinketGui gui) {
        return ((JEIAreaProvider) gui).jei_area_fixer$getAreas();
    }
}
