package zzzank.mod.jei_area_fixer.mods.reskillable;

import codersafterdark.reskillable.base.ConfigHandler;
import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

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

    private static final List<GuiButtonInventoryTab> BUTTONS = new ArrayList<>();

    public static void acceptButton(GuiButtonInventoryTab button) {
        BUTTONS.add(button);
    }

    public ReskillableTabArea() {
        super(GuiContainer.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        if (!ConfigHandler.enableTabs) {
            return Collections.emptyList();
        }
        List<Rectangle> areas = new ArrayList<>();
        for (GuiButtonInventoryTab b : BUTTONS) {
            if (b.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(b));
            }
        }
        return areas;
    }
}
