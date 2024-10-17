package zzzank.mod.jei_area_fixer.debug;

import lombok.val;
import net.minecraft.client.gui.inventory.GuiContainer;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
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
    public static final long PRINT_INTERVAL = 3000;

    static final Map<Class<? extends GuiContainer>, List<Rectangle>> boundsMap = new ConcurrentHashMap<>();
    /**
     * a collection of jei areas that will then be used for `debug$drawing`
     */
    public static Collection<Rectangle> capturedAreas = null;

    public static void accept(Class<? extends GuiContainer> target, List<Rectangle> bounds) {
        if (bounds != null && (JEIAreaFixerConfig.DEBUG.print || JEIAreaFixerConfig.DEBUG.draw)) {
            boundsMap.put(target, bounds);
        }
    }

    static ArrayList<Rectangle> collectActiveBounds(Class<? extends GuiContainer> target) {
        val bounds = new ArrayList<Rectangle>();
        for (val e : boundsMap.entrySet()) {
            if (!e.getKey().isAssignableFrom(target)) {
                continue;
            }
            bounds.addAll(e.getValue());
        }
        return bounds;
    }
}
