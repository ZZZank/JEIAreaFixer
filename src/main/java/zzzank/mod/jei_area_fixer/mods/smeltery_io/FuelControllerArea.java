package zzzank.mod.jei_area_fixer.mods.smeltery_io;

import mctmods.smelteryio.tileentity.gui.GuiFC;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class FuelControllerArea extends AbstractJEIAreaProvider<GuiFC> {

    @Nonnull
    @Override
    protected Class<GuiFC> getTarget() {
        return GuiFC.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiFC gui) {
        //this.drawTexturedModalRect(this.guiLeft - 110, this.guiTop, 146, 170, 110, 60);
        return Collections.singletonList(
            new Rectangle(
                gui.getGuiLeft() - 110,
                gui.getGuiTop(),
                110,
                60
            )
        );
    }
}
