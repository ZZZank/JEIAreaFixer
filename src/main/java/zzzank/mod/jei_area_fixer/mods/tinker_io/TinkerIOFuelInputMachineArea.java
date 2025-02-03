package zzzank.mod.jei_area_fixer.mods.tinker_io;

import tinker_io.gui.GuiFuelInputMachine;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class TinkerIOFuelInputMachineArea extends AbstractJEIAreaProvider<GuiFuelInputMachine> {

    @Nonnull
    @Override
    protected Class<GuiFuelInputMachine> getTarget() {
        return GuiFuelInputMachine.class;
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiFuelInputMachine gui) {
        return ((JEIAreaProvider) gui).jei_area_fixer$getAreas();
    }
}
