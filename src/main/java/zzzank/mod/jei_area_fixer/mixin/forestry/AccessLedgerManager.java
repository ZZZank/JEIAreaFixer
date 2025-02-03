package zzzank.mod.jei_area_fixer.mixin.forestry;

import forestry.core.gui.ledgers.ErrorLedger;
import forestry.core.gui.ledgers.LedgerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(value = LedgerManager.class, remap = false)
public interface AccessLedgerManager {

    @Accessor("errorLedgers")
    List<ErrorLedger> jaf$errorLedgers();
}
