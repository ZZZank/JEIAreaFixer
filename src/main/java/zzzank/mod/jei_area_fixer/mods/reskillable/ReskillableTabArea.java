package zzzank.mod.jei_area_fixer.mods.reskillable;

import codersafterdark.reskillable.base.ConfigHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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
        if (!ConfigHandler.enableTabs) {
            return Collections.emptyList();
        }
        var access = ((ButtonsCacheHolder) gui);

        var cache = access.jaf$cacheIfAbsent(ButtonIndex.RESKILLABLE);

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var reskillableButton : cache) {
            if (reskillableButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(reskillableButton));
            }
        }
        return areas;
    }
}
