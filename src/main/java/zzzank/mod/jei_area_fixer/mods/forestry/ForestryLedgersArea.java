package zzzank.mod.jei_area_fixer.mods.forestry;

import forestry.core.gui.GuiForestry;
import lombok.val;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.mixin.forestry.AccessGuiForestry;
import zzzank.mod.jei_area_fixer.mixin.forestry.AccessLedgerManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

        val areas = new ArrayList<Rectangle>(errorLedgers.size());
        for (val ledger : errorLedgers) {
            if (ledger.isVisible()) {
                areas.add(ledger.getArea());
            }
        }
        return areas;
    }
}
