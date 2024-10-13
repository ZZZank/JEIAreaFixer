package zzzank.mod.jei_area_fixer.mods.minecraft;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;

/**
 * @author ZZZank
 */
public abstract class GeneralButtonsAreaProvider<T extends GuiButton> extends ButtonsAreaProvider<T, GuiContainer> {

    public GeneralButtonsAreaProvider(ButtonIndex<T> index) {
        super( GuiContainer.class, index);
    }
}
