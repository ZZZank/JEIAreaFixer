package zzzank.mod.jei_area_fixer.mixin.gamblingstyle;

import com.fuzs.gamblingstyle.client.gui.GuiTradingBook;
import com.fuzs.gamblingstyle.client.gui.GuiVillager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.gamblingstyle.GuiVillagerAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiVillager.class)
public interface AccessGuiVillager extends GuiVillagerAccessor {

    @Override
    @Accessor(value = "tradingBookGui", remap = false)
    GuiTradingBook jaf$tradingBookGui();
}
