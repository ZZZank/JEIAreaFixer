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
    public TinkerIOFuelInputMachineArea() {
        super(GuiFuelInputMachine.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiFuelInputMachine gui) {
        return ((JEIAreaProvider) gui).jei_area_fixer$getAreas();
    }
}
