package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

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
        super(JEIAreaFixer.cast(GuiForestry.class));
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiForestry<?> gui) {
        var ledgerManager = ((GuiForestryAccessor) gui).jaf$ledgerManager();
        var errorLedgers = ((LedgerManagerAccessor) ledgerManager).jaf$errorLedgers();

        var areas = new ArrayList<Rectangle>(errorLedgers.size());

        for (var ledger : errorLedgers) {
            if (ledger.isVisible()) {
                areas.add(ledger.getArea());
            }
        }
        return areas;
    }
}
