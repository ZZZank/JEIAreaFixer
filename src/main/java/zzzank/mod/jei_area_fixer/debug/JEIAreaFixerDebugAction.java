package zzzank.mod.jei_area_fixer.debug;

import lombok.val;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.Tags;
import zzzank.mod.jei_area_fixer.utils.ScheduledTaskThread;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Tags.MOD_ID)
public class JEIAreaFixerDebugAction {

    public static final ScheduledTaskThread messageSender = new ScheduledTaskThread(
        Tags.MOD_ID + " scheduled print",
        JEIAreaFixerDebug.PRINT_INTERVAL,
        JEIAreaFixerDebugAction::print
    );
    private static final Map<Class<? extends GuiContainer>, List<Rectangle>> lastBounds = new IdentityHashMap<>();

    static {
        messageSender.setDaemon(true);
        messageSender.start();
    }

    public static void print() {
        if (!JEIAreaFixerConfig.DEBUG.print || JEIAreaFixerDebug.boundsMap.isEmpty()) {
            return;
        }
        val joiner = new StringJoiner("\n");
        for (val e : JEIAreaFixerDebug.boundsMap.entrySet()) {
            val key = e.getKey();
            val value = e.getValue();
            if (value.equals(lastBounds.get(key))) {
                continue;
            }
            lastBounds.put(key, value);
            joiner.add(String.format(
                "class '%s' with new bounds: %s",
                e.getKey(),
                e.getValue()
                    .stream()
                    .map(bound -> "[x: " + bound.x
                        + ", y: " + bound.y
                        + ", width: " + bound.width
                        + ", height: " + bound.height
                        + "]")
                    .collect(Collectors.joining(", "))
            ));
        }
        if (joiner.length() == 0) {
            return;
        }
        System.out.println("debug output from " + Tags.MOD_NAME + "\n" + joiner);
    }

    /**
     * lowest priority to make it at the front
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void drawing(GuiScreenEvent.DrawScreenEvent.Post event) {
        if (!JEIAreaFixerConfig.DEBUG.draw || !(event.getGui() instanceof GuiContainer)) {
            return;
        }
        val guiContainer = (GuiContainer) event.getGui();
        if (!JEIAreaFixerConfig.DEBUG.drawAll) {
            //if the config is enabled, we won't need to collect it by ourselves
            JEIAreaFixerDebug.capturedAreas = JEIAreaFixerDebug.collectActiveBounds(guiContainer.getClass());
        }
        for (val area : JEIAreaFixerDebug.capturedAreas) {
            Gui.drawRect(
                area.x,
                area.y,
                area.x + area.width,
                area.y + area.height,
                0x7f4169e1
            );
        }
    }
}
