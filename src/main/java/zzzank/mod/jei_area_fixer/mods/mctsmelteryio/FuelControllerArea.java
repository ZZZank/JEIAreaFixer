package zzzank.mod.jei_area_fixer.mods.mctsmelteryio;

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

    public FuelControllerArea() {
        super(GuiFC.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiFC gui) {
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
