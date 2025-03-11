package zzzank.mod.jei_area_fixer.mixin.minecraft;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZZZank
 */
@Mixin(GuiContainer.class)
public abstract class MixinGuiContainer extends GuiScreen implements ButtonsCacheHolder {

    /**
     * caching buttons to prevent button lookup at every render request
     */
    @Unique
    private final Map<Integer, List<GuiButton>> jeiAreaFixer$buttonsCache = new HashMap<>();

    @Override
    public Map<Integer, List<GuiButton>> jaf$getCache() {
        return jeiAreaFixer$buttonsCache;
    }

    @Override
    public List<GuiButton> jaf$getButtonList() {
        return this.buttonList;
    }
}
