package zzzank.mod.jei_area_fixer.mods.xat;

import xzeroair.trinkets.client.gui.TrinketGui;
import xzeroair.trinkets.util.TrinketsConfig;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class TrinketGuiArea extends AbstractJEIAreaProvider<TrinketGui> {
    public TrinketGuiArea() {
        super(TrinketGui.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull TrinketGui gui) {
        var cfg = TrinketsConfig.CLIENT.GUI;
        return null;
    }
}
