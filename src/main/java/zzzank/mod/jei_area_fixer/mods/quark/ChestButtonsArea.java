package zzzank.mod.jei_area_fixer.mods.quark;

import com.google.common.base.Suppliers;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import vazkii.quark.base.module.ModuleLoader;
import vazkii.quark.management.QuarkManagement;
import vazkii.quark.management.feature.ChestButtons;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @see vazkii.quark.management.feature.ChestButtons
 * @see vazkii.quark.management.client.gui.GuiButtonChest
 * @author ZZZank
 */
public class ChestButtonsArea implements IAdvancedGuiHandler<GuiContainer> {

    private static final Supplier<ChestButtons> feature = Suppliers.memoize(() -> {
        var module = ModuleLoader.moduleInstances.get(QuarkManagement.class);
        if (module == null) {
            return null; //should not happen, but anyway
        }
        return (ChestButtons) module.getFeatures().get(ChestButtons.class.getSimpleName());
    });
    private static final Object[] ALL_BUTTONS = new Object[] {
        ChestButtons.deposit,
        ChestButtons.smartDeposit,
        ChestButtons.restock,
        ChestButtons.extract,
        ChestButtons.sort,
        ChestButtons.sortPlayer
    };

    @Override
    @Nonnull
    public Class<GuiContainer> getGuiContainerClass() {
        return GuiContainer.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(@Nonnull GuiContainer gui) {
        var chestButtons = feature.get();
        if (!chestButtons.enabled) {
            return Collections.emptyList();
        }
        var areas = new ArrayList<Rectangle>(ALL_BUTTONS.length);
        for (Object button : ALL_BUTTONS) {
            if (button instanceof ButtonInfoAccessor access && access.get$enabled()) {
                areas.add(new Rectangle());
            }
        }
        return areas;
    }
}
