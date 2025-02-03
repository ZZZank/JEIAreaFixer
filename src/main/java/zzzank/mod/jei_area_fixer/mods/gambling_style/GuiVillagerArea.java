package zzzank.mod.jei_area_fixer.mods.gambling_style;

import com.fuzs.gamblingstyle.client.gui.GuiVillager;
import lombok.val;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mixin.gamblingstyle.AccessGuiTradingBook;
import zzzank.mod.jei_area_fixer.mixin.gamblingstyle.AccessGuiVillager;

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
        val book = ((AccessGuiVillager) gui).jaf$tradingBookGui();
        val access = ((AccessGuiTradingBook) book);
        return Collections.singletonList(
            new Rectangle(access.jaf$guiLeft(), access.jaf$guiTop(), access.jaf$xSize(), access.jaf$ySize())
        );
    }
}
