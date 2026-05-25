package zzzank.mod.jei_area_fixer.mods.refinedstorage;

import com.raoulvdberge.refinedstorage.gui.control.SideButton;
import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonIndex;
import zzzank.mod.jei_area_fixer.mods.minecraft.GeneralButtonsAreaProvider;
import zzzank.mod.jei_area_fixer.utils.AreaFilter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZZZank
 */
public class RefinedStorageSideButtonArea extends GeneralButtonsAreaProvider<SideButton> {

    private static final ButtonIndex<SideButton> BUTTON_INDEX
        = ButtonIndex.register(button -> button instanceof SideButton);

    @Override
    protected ButtonIndex<SideButton> getButtonIndex() {
        return BUTTON_INDEX;
    }

    @Nullable
    @Override
    protected List<Rectangle> buttonsToAreas(@Nonnull List<SideButton> buttons, @Nonnull GuiContainer gui) {
        val result = new ArrayList<Rectangle>();
        for (val button : buttons) {
            if (button.visible && AreaFilter.notShiftingBookmarkRS(button)) {
                result.add(new Rectangle(button.x, button.y, SideButton.WIDTH, SideButton.HEIGHT));
            }
        }
        return result;
    }
}
