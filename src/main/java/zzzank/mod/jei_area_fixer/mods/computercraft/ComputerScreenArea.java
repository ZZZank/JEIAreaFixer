package zzzank.mod.jei_area_fixer.mods.computercraft;

import dan200.computercraft.client.gui.GuiComputer;
import lombok.val;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
public class ComputerScreenArea extends AbstractJEIAreaProvider<GuiComputer> {

    private static final int BORDER_WIDTH = 12;

    public ComputerScreenArea() {
        super(GuiComputer.class);
    }

    /**
     * @see GuiComputer#drawScreen(int, int, float)
     */
    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiComputer gui) {
        val terminal = ((GuiComputerAccessor) gui).jaf$terminal();
        val startX = (gui.width - terminal.getWidth()) / 2;
        val startY = (gui.height - terminal.getHeight()) / 2;
        return Collections.singletonList(
            new Rectangle(
                startX - BORDER_WIDTH,
                startY - BORDER_WIDTH,
                gui.getXSize(),
                gui.getYSize()
            )
        );
    }
}
