package zzzank.mod.jei_area_fixer.mixin.minecraft;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import zzzank.mod.jei_area_fixer.mods.minecraft.ButtonsCacheHolder;

import java.util.List;

/**
 * @author ZZZank
 */
@Mixin(GuiContainer.class)
public abstract class MixinGuiContainer extends GuiScreen implements ButtonsCacheHolder {

    /**
     * caching buttons to prevent button lookup at every render request
     */
    @Unique
    private final Int2ObjectMap<List<GuiButton>> jeiAreaFixer$buttonsCache = new Int2ObjectOpenHashMap<>();

    @Override
    public Int2ObjectMap<List<GuiButton>> jeiAreaFixer$getCache() {
        return jeiAreaFixer$buttonsCache;
    }

    @Override
    public List<GuiButton> jeiAreaFixer$getButtonList() {
        return this.buttonList;
    }
}
