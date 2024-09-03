package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.ledgers.ErrorLedger;

import java.util.List;

/**
 * @author ZZZank
 */
public interface LedgerManagerAccessor {

    List<ErrorLedger> get$errorLedgers();
}
