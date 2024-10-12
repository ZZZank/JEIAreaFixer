package zzzank.mod.jei_area_fixer.mods.blue_skies;

import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;

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
        var cache = access.jaf$cacheIfAbsent(
            ButtonIndex.BLUE_SKIES
        );

        var areas = new ArrayList<Rectangle>(cache.size());
        for (var button : cache) {
            if (button.visible) {
                areas.add(rectFromTab(button));
            }
        }
        return areas;
    }

    /**
     * @see SkyTab#drawButton(Minecraft, int, int, float)
     */
    private static Rectangle rectFromTab(SkyTab tab) {
        return new Rectangle(
            tab.x,
            tab.y,
            tab.enabled ? 185 - ((SkyTabAccessor) tab).jaf$slidePos() : tab.width,
            tab.height
        );
    }
}
