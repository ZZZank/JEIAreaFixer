package zzzank.mod.jei_area_fixer.mods.gamblingstyle;

import com.fuzs.gamblingstyle.client.gui.GuiVillager;
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
public class GuiVillagerArea extends AbstractJEIAreaProvider<GuiVillager> {

    public GuiVillagerArea() {
        super(GuiVillager.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiVillager gui) {
        val book = ((GuiVillagerAccessor) gui).jaf$tradingBookGui();
        val access = ((GuiTradingBookAccessor) book);
        return Collections.singletonList(
            new Rectangle(access.jaf$guiLeft(), access.jaf$guiTop(), access.jaf$xSize(), access.jaf$ySize())
        );
    }
}
