package zzzank.mod.jei_area_fixer.debug;

import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZZZank
 * @see JEIAreaFixerDebugAction
 */
public final class JEIAreaFixerDebug {

    /**
     * in milliseconds
     */
    public static final long INTERVAL = 3000;

    static final Map<Class<? extends GuiContainer>, List<Rectangle>> boundsMap = new ConcurrentHashMap<>();
    public static final ScheduledTaskThread messageSender =
        new ScheduledTaskThread(INTERVAL, JEIAreaFixerDebugAction::print);

    static {
        messageSender.setDaemon(true);
        messageSender.start();
    }

    public static void accept(Class<? extends GuiContainer> target, List<Rectangle> bounds) {
        if (bounds == null) {
            return;
        }
        if (JEIAreaFixerConfig.debug$print || JEIAreaFixerConfig.debug$drawing) {
            boundsMap.put(target, bounds);
        }
    }
}
