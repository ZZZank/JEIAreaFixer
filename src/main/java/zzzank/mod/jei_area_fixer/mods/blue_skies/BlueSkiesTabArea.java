package zzzank.mod.jei_area_fixer.mods.blue_skies;

import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheIndexes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see SkyTab
 * @author ZZZank
 */
public class BlueSkiesTabArea extends AbstractJEIAreaProvider<GuiContainer> {
    public BlueSkiesTabArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        var access = ((ButtonsCacheHolder) gui);
        var cache = access.jeiAreaFixer$computeCacheIfAbsent(
            ButtonsCacheIndexes.BLUE_SKIES,
            SkyTab.class
        );

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var button : cache) {
            if (button.visible) {
                areas.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return areas;
    }
}
