package zzzank.mod.jei_area_fixer.mods.smeltery_io;

import mctmods.smelteryio.tileentity.gui.GuiCM;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class CastingMachineArea extends AbstractJEIAreaProvider<GuiCM> {

    @Nonnull
    @Override
    protected Class<GuiCM> getTarget() {
        return GuiCM.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiCM gui) {
        return ((JEIAreaProvider) gui).jei_area_fixer$getAreas();
    }
}