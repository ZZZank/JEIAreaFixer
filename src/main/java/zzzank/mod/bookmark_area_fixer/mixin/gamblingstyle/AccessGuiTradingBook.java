package zzzank.mod.bookmark_area_fixer.mixin.gamblingstyle;

import com.fuzs.gamblingstyle.client.gui.GuiTradingBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.bookmark_area_fixer.mods.gamblingstyle.GuiTradingBookAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiTradingBook.class)
public interface AccessGuiTradingBook extends GuiTradingBookAccessor {

    @Accessor(value = "xSize", remap = false)
    int get$xSize();

    @Accessor(value = "ySize", remap = false)
    int get$ySize();

    @Accessor(value = "guiLeft", remap = false)
    int get$guiLeft();

    @Accessor(value = "guiTop", remap = false)
    int get$guiTop();
}
