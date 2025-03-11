package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import forestry.core.gui.ledgers.ErrorLedger;
import forestry.core.gui.ledgers.Ledger;
import lombok.val;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mixin.forestry.AccessGuiForestry;
import zzzank.mod.jei_area_fixer.mixin.forestry.AccessLedgerManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
public class ForestryLedgersArea extends AbstractJEIAreaProvider<GuiForestry<?>> {

    @Nonnull
    @Override
    protected Class<GuiForestry<?>> getTarget() {
        return cast(GuiForestry.class);
    }

    @Nullable
    @Override
    protected List<Rectangle> getExclusionAreas(@Nonnull GuiForestry<?> gui) {
        val ledgerManager = ((AccessGuiForestry) gui).jaf$ledgerManager();
        val errorLedgers = ((AccessLedgerManager) ledgerManager).jaf$errorLedgers();

        return errorLedgers.stream()
            .filter(ErrorLedger::isVisible)
            .map(Ledger::getArea)
            .collect(Collectors.toList());
    }
}
