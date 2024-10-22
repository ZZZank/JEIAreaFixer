package zzzank.mod.jei_area_fixer.mods.blue_skies;

import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraftforge.client.event.GuiScreenEvent;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see SkyTab
 * @see codersafterdark.reskillable.client.gui.handler.InventoryTabHandler#initGui(GuiScreenEvent.InitGuiEvent.Post)
 * @author ZZZank
 */
public class BlueSkiesTabArea extends ButtonsAreaProvider<SkyTab, InventoryEffectRenderer> {
    public BlueSkiesTabArea() {
        super(ButtonIndex.BLUE_SKIES, InventoryEffectRenderer.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<SkyTab> buttons, @Nonnull InventoryEffectRenderer gui) {
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
