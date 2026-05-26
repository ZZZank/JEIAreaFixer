package zzzank.mod.jei_area_fixer.mods.minecraft;

import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
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
        val scaledResolution = new ScaledResolution(gui.mc);

        val result = new ArrayList<Rectangle>();

        val visible = gui.mc.getToastGui().visible;
        for (int i = 0; i < visible.length; i++) {
            val toastInstance = visible[i];
            if (toastInstance != null) {
                val visibility = toastInstance.getVisibility(Minecraft.getSystemTime());
                val visibleWidth = (int) (160 * visibility);
                result.add(new Rectangle(scaledResolution.getScaledWidth() - visibleWidth, i * 32, visibleWidth, 32));
            }
        }

        return result;
    }
}
