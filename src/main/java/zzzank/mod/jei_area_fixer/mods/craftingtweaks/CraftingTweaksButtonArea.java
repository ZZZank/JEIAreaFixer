package zzzank.mod.jei_area_fixer.mods.craftingtweaks;

import com.google.common.collect.ImmutableList;
import lombok.val;
import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class CraftingTweaksButtonArea extends ButtonsAreaProvider<GuiTweakButton> {
    public CraftingTweaksButtonArea() {
        super(ButtonIndex.CRAFTING_TWEAKS);
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull ImmutableList<GuiTweakButton> buttons, @Nonnull GuiContainer gui) {
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
