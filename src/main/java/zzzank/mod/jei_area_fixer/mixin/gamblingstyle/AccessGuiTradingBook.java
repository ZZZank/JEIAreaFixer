package zzzank.mod.jei_area_fixer.mixin.gamblingstyle;

import com.fuzs.gamblingstyle.client.gui.GuiTradingBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.gambling_style.GuiTradingBookAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiTradingBook.class)
public interface AccessGuiTradingBook extends GuiTradingBookAccessor {

    @Accessor(value = "xSize", remap = false)
    int jaf$xSize();

    @Accessor(value = "ySize", remap = false)
    int jaf$ySize();

    @Accessor(value = "guiLeft", remap = false)
    int jaf$guiLeft();

    @Accessor(value = "guiTop", remap = false)
    int jaf$guiTop();
}
