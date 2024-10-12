package zzzank.mod.jei_area_fixer.mods.rftools;

import mcjty.rftools.blocks.storage.GuiModularStorage;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class ModularStorageArea extends AbstractJEIAreaProvider<GuiModularStorage> {

    public ModularStorageArea() {
        super(GuiModularStorage.class);
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiModularStorage gui) {
        var craftingGrid = ((StorageWithCraftGuiAccessor) gui).jaf$craftingGrid();
        var window = ((GuiCraftingGridAccessor) craftingGrid).jaf$craftWindow();
        return JEIAreaFixer.nullableWrap(window.getToplevel().getBounds());
    }
}
