package zzzank.mod.jei_area_fixer.mixin.minecraft;

import codersafterdark.reskillable.base.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import vazkii.quark.management.client.gui.GuiButtonChest;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;
import zzzank.mod.jei_area_fixer.mods.ModState;
import zzzank.mod.jei_area_fixer.mods.quark.QuarkAreasProvider;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ZZZank
 */
@Mixin(GuiContainer.class)
public abstract class MixinGuiContainerForQuark extends GuiScreen implements QuarkAreasProvider {

    /**
     * caching buttons to prevent button lookup at every render request
     * <p>
     * there are currently at most 6 buttons
     * @see vazkii.quark.management.feature.ChestButtons
     */
    @Unique
    private final List<GuiButtonChest> quarkButtons = new ArrayList<>(6);

    @Override
    public List<Rectangle> jei_area_fixer$getQuarkAreas() {
        if (!ConfigHandler.enableTabs || !ModState.QUARK) {
            return Collections.emptyList();
        }
        if (this.quarkButtons.isEmpty()) {
            for (var b : this.buttonList) {
                if (b instanceof GuiButtonChest button) {
                    quarkButtons.add(button);
                }
            }
        }
        var areas = new ArrayList<Rectangle>(quarkButtons.size());
        for (var quarkButton : quarkButtons) {
            if (quarkButton.enabled) {
                areas.add(JEIAreaFixer.rectFromButton(quarkButton));
            }
        }
        return areas;
    }
}
