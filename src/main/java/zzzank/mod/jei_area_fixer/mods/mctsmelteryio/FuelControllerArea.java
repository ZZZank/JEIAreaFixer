package zzzank.mod.jei_area_fixer.mods.mctsmelteryio;

import mctmods.smelteryio.tileentity.gui.GuiFC;
import mezz.jei.api.gui.IAdvancedGuiHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class FuelControllerArea implements IAdvancedGuiHandler<GuiFC> {

    @Override
    @Nonnull
    public Class<GuiFC> getGuiContainerClass() {
        return GuiFC.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(GuiFC gui) {
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
