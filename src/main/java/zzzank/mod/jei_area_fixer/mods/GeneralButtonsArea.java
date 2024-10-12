package zzzank.mod.jei_area_fixer.mods;

import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import lombok.val;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zzzank.mod.jei_area_fixer.AbstractJEIAreaProvider;
import zzzank.mod.jei_area_fixer.JEIAreaFixer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author ZZZank
 */
public class GeneralButtonsArea extends AbstractJEIAreaProvider<GuiContainer> {

    private final Map<Class<? extends GuiContainer>, List<GuiButton>> buttonsMap = new IdentityHashMap<>();
    /**
     * used for clearing areas if not refreshed for a long time
     */
    private final Object2LongMap<Class<? extends GuiContainer>> timestamps = new Object2LongOpenHashMap<>();
    /**
     * in milliseconds
     */
    private static final long INTERVAL = 1000;

    public GeneralButtonsArea() {
        super(GuiContainer.class);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void readButtonInfos(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiContainer) {
            val guiContainer = (GuiContainer) event.getGui();
            buttonsMap.put(guiContainer.getClass(), event.getButtonList());
        }
    }

    @Nullable
    @Override
    public List<Rectangle> getExtraAreas(@Nonnull GuiContainer gui) {
        val buttons = buttonsMap.get(gui.getClass());
        if (buttons == null || buttons.isEmpty()) {
            return Collections.emptyList();
        }
        val currTime = System.currentTimeMillis();
        val lastTime = timestamps.put(gui.getClass(), currTime);
        if (currTime - lastTime > INTERVAL) {
            buttonsMap.remove(gui.getClass());
            return Collections.emptyList();
        }
        val bounds = new ArrayList<Rectangle>(buttons.size());
        for (val button : buttons) {
            if (button.visible || button.enabled) { // not a good idea, but SOME mod devs are not using these two options correctly
                bounds.add(JEIAreaFixer.rectFromButton(button));
            }
        }
        return bounds;
    }
}
