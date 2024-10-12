package zzzank.mod.jei_area_fixer.mixin.forestry;

import forestry.core.gui.GuiForestry;
import forestry.core.gui.ledgers.LedgerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.forestry.GuiForestryAccessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiForestry.class,remap = false)
public interface AccessGuiForestry extends GuiForestryAccessor {

    @Accessor("ledgerManager")
    @Override
    LedgerManager jaf$ledgerManager();
}
