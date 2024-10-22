package zzzank.mod.jei_area_fixer.mods.applied_energistics_2;

import appeng.client.gui.implementations.GuiMEMonitorable;
import appeng.client.gui.implementations.GuiSecurityStation;
import lombok.val;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mixin.appliedenergistics2.AccessGuiMEMonitorable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class AE2CellViewArea extends AbstractJEIAreaProvider<GuiMEMonitorable> {
    public AE2CellViewArea() {
        super(GuiMEMonitorable.class);
    }

    /**
     * @see GuiMEMonitorable#drawBG(int, int, int, int)
     */
    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiMEMonitorable gui) {
        val access = ((AccessGuiMEMonitorable) gui);

        return access.jaf$viewCell() || gui instanceof GuiSecurityStation
//        this.drawTexturedModalRect(offsetX + 197, offsetY, 197, 0, 46, 128); but actual area different
            ? Collections.singletonList(new Rectangle(
                gui.getGuiLeft() + 197,
                gui.getGuiTop(),
                24, //originally fixed 36
                access.jaf$monitorableContainer().getViewCells().length * 19 //originally fixed 112
            ))
            : null;
    }
}
