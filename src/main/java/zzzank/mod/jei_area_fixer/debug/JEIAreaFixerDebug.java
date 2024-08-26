package zzzank.mod.jei_area_fixer.debug;

import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.Tags;

import java.awt.*;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Tags.MOD_ID)
public final class JEIAreaFixerDebug {

    /**
     * 500ms = 0.5s
     */
    public static final long INTERVAL = 500;

    private static final Object2LongMap<Class<?>> timestamps = new Object2LongOpenHashMap<>();
    private static final Map<Class<?>, List<Rectangle>> boundsMap = new IdentityHashMap<>();
    public static final ScheduledPrintThread messageSender = JEIAreaFixerConfig.debug$print
        ? new ScheduledPrintThread(INTERVAL, JEIAreaFixerDebug::print)
        : null;

    public static void accept(Class<?> target, List<Rectangle> bounds) {
        if (bounds == null) {
            return;
        }
        final long current = System.currentTimeMillis();
        final long last = timestamps.getLong(target);
        if (current - last < INTERVAL) {
            return;
        }
        timestamps.put(target, current);
        boundsMap.computeIfAbsent(target, k -> new ArrayList<>()).addAll(bounds);
    }

    public static void print() {
        if (!JEIAreaFixerConfig.debug$print) {
            return;
        }
        var lines = boundsMap.entrySet()
            .stream()
            .map(e -> String.format(
                "class '%s' with bounds: %s",
                e.getKey(),
                e.getValue()
                    .stream()
                    .map(bound -> new StringBuilder(40)
                        .append("[x: ").append(bound.x)
                        .append(", y: ").append(bound.y)
                        .append(", width: ").append(bound.width)
                        .append(", height: ").append(bound.height)
                        .append("]")
                        .toString())
                    .collect(Collectors.joining(", "))
            ))
            .collect(Collectors.joining("\n"));
        System.out.println("debug output from" + Tags.MOD_NAME + "\n" + lines);
    }

    @SubscribeEvent
    public static void drawing(GuiScreenEvent.DrawScreenEvent event) {
        if (!JEIAreaFixerConfig.debug$drawing) {
            return;
        }
        var gui = event.getGui();
        var bounds = boundsMap.get(gui.getClass());
        if (bounds == null) {
            return;
        }
        for (var bound : bounds) {
            GuiUtils.drawGradientRect(
            Integer.MAX_VALUE,
                    bound.x,
                bound.y,
                bound.x + bound.width,
                bound.y + bound.height,
                0xff4169e1,
                0xff4169e1
            );
        }
    }
}
