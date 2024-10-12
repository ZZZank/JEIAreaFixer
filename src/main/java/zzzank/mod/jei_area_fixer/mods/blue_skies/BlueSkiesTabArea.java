package zzzank.mod.jei_area_fixer.mods.blue_skies;

import com.google.common.collect.ImmutableList;
import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;
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
public class BlueSkiesTabArea extends ButtonsAreaProvider<SkyTab> {
    public BlueSkiesTabArea() {
        super(ButtonIndex.BLUE_SKIES);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull ImmutableList<SkyTab> buttons, @Nonnull GuiContainer gui) {
        val areas = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
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
