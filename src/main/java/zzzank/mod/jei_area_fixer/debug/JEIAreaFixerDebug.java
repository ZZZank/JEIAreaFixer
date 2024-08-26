package zzzank.mod.jei_area_fixer.debug;

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
     * 500ms = 0.5s
     */
    public static final long INTERVAL = 500;

    static final Map<Class<?>, List<Rectangle>> boundsMap = new IdentityHashMap<>();
    public static final ScheduledTaskThread messageSender =
        new ScheduledTaskThread(INTERVAL, JEIAreaFixerDebugAction::print);

    static {
        messageSender.setDaemon(true);
        messageSender.start();
    }

    public static void accept(Class<?> target, List<Rectangle> bounds) {
        if (bounds == null) {
            return;
        }
        boundsMap.put(target, bounds);
    }
}
