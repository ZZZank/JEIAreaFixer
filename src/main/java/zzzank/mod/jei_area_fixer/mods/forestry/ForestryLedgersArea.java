package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import lombok.val;
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
        val ledgerManager = ((GuiForestryAccessor) gui).jaf$ledgerManager();
        val errorLedgers = ((LedgerManagerAccessor) ledgerManager).jaf$errorLedgers();

        val areas = new ArrayList<Rectangle>(errorLedgers.size());
        for (val ledger : errorLedgers) {
            if (ledger.isVisible()) {
                areas.add(ledger.getArea());
            }
        }
        return areas;
    }
}
