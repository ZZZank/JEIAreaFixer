package zzzank.mod.jei_area_fixer.mods.cyclic;

import com.lothrazar.cyclicmagic.playerupgrade.storage.GuiPlayerExtended;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * for Armor slots in extended player inventory
 *
 * @author ZZZank
 * @see GuiPlayerExtended#drawGuiContainerBackgroundLayer(float, int, int)
 */
public class ExtendedArmorInventoryArea extends AbstractJEIAreaProvider<GuiPlayerExtended> {
    public ExtendedArmorInventoryArea() {
        super(GuiPlayerExtended.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiPlayerExtended gui) {
        final int w = 47; //width
        final int h = 85; //height
//        Gui.drawModalRectWithCustomSizedTexture(this.guiLeft - w, this.guiTop, (float)u, (float)v, w, h, (float)w, (float)h);
        return Collections.singletonList(
            new Rectangle(
                gui.getGuiLeft() - w,
                gui.getGuiTop(),
                w,
                h
            )
        );
    }
}
