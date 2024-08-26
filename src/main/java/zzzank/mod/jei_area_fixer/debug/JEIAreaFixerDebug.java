package zzzank.mod.jei_area_fixer.debug;

import net.minecraft.client.gui.inventory.GuiContainer;

import java.awt.*;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZZZank
 * @see JEIAreaFixerDebugAction
 */
public final class JEIAreaFixerDebug {

    /**
     * in milliseconds
     */
    public static final long INTERVAL = 3000;

    static final Map<Class<? extends GuiContainer>, List<Rectangle>> boundsMap = new IdentityHashMap<>();
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
        boundsMap.put(target, bounds);
    }
}
