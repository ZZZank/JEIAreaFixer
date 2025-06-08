package zzzank.mod.jei_area_fixer.mods.minecraft;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;

import javax.annotation.Nonnull;

/**
 * @author ZZZank
 */
public abstract class GeneralButtonsAreaProvider<T extends GuiButton>
    extends ButtonsAreaProvider<T, GuiContainer> {

    @Nonnull
    @Override
    protected Class<GuiContainer> getTarget() {
        return GuiContainer.class;
    }
}
