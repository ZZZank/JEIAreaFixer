package zzzank.mod.jei_area_fixer.mixin.forestry;

import forestry.core.gui.ledgers.ErrorLedger;
import forestry.core.gui.ledgers.LedgerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.forestry.LedgerManagerAccessor;

import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(value = LedgerManager.class, remap = false)
public interface AccessLedgerManager extends LedgerManagerAccessor {

    @Accessor("errorLedgers")
    @Override
    List<ErrorLedger> jaf$errorLedgers();
}
