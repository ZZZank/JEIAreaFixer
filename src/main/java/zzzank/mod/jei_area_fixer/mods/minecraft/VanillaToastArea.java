package zzzank.mod.jei_area_fixer.mods.minecraft;

import lombok.val;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class VanillaToastArea extends AbstractJEIAreaProvider<GuiContainer> {
    @Nonnull
    @Override
    protected Class<GuiContainer> getTarget() {
        return GuiContainer.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiContainer gui) {
        val toastGui = gui.mc.getToastGui();

        int maxIndex = 0;
        for (int i = 0; i < toastGui.visible.length; i++) {
            if (toastGui.visible[i] != null) {
                maxIndex = i;
            }
        }

        if (maxIndex == 0) {
            return Collections.emptyList();
        }

        val scaledResolution = new ScaledResolution(gui.mc);
        return Collections.singletonList(new Rectangle(
            scaledResolution.getScaledWidth() - 160,
            0,
            160,
            (maxIndex + 1) * 32
        ));
    }
}
