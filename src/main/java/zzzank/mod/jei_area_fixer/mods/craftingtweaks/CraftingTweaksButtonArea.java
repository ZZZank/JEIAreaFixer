package zzzank.mod.jei_area_fixer.mods.craftingtweaks;

import lombok.val;
import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @see net.blay09.mods.craftingtweaks.CraftingTweaks#getProvider(Container)
 * @author ZZZank
 */
public class CraftingTweaksButtonArea extends GeneralButtonsAreaProvider<GuiTweakButton> {
    public CraftingTweaksButtonArea() {
        super(ButtonIndex.CRAFTING_TWEAKS);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<GuiTweakButton> buttons, @Nonnull GuiContainer gui) {
        val areas = new ArrayList<Rectangle>();
        for (val button : buttons) {
            val access = ((GuiTweakButtonAccessor) button);
            areas.add(new Rectangle(
                button.x + access.jaf$lastGuiLeft(),
                button.y + access.jaf$lastGuiTop(),
                button.width,
                button.height
            ));
        }
        return areas;
    }
}
