package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class ForestryLedgersArea extends AbstractJEIAreaProvider<GuiForestry<?>> {
    public ForestryLedgersArea() {
        super((Class<GuiForestry<?>>) (Object) GuiForestry.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiForestry<?> gui) {
        var ledgerManager = ((GuiForestryAccessor) gui).get$ledgerManager();
        var errorLedgers = ((LedgerManagerAccessor) ledgerManager).get$errorLedgers();

        var areas = new ArrayList<Rectangle>(errorLedgers.size());
        for (var ledger : errorLedgers) {
            if (ledger.isVisible()) {
                areas.add(ledger.getArea());
            }
        }
        return areas;
    }
}
