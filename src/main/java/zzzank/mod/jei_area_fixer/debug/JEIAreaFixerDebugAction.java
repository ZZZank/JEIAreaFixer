package zzzank.mod.jei_area_fixer.debug;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import zzzank.mod.jei_area_fixer.JEIAreaFixerConfig;
import zzzank.mod.jei_area_fixer.Tags;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Tags.MOD_ID)
public class JEIAreaFixerDebugAction {

    private static final Map<Class<? extends GuiContainer>, List<Rectangle>> lastBounds = new IdentityHashMap<>();
    /**
     * a collection of jei areas that will then be used for `debug$drawing`
     */
    public static Collection<Rectangle> capturedAreas = null;

    public static void print() {
        if (!JEIAreaFixerConfig.debug$print || JEIAreaFixerDebug.boundsMap.isEmpty()) {
            return;
        }
        var joiner = new StringJoiner("\n");
        for (var e : JEIAreaFixerDebug.boundsMap.entrySet()) {
            var key = e.getKey();
            var value = e.getValue();
            if (value.equals(lastBounds.get(key))) {
                continue;
            }
            lastBounds.put(key, value);
            joiner.add(String.format(
                "class '%s' with new bounds: %s",
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
            ));
        }
        if (joiner.length() == 0) {
            return;
        }
        System.out.println("debug output from " + Tags.MOD_NAME + "\n" + joiner);
    }

    public static ArrayList<Rectangle> collectActiveBounds(Class<? extends GuiContainer> target) {
        var bounds = new ArrayList<Rectangle>();
        for (var e : JEIAreaFixerDebug.boundsMap.entrySet()) {
            if (!e.getKey().isAssignableFrom(target)) {
                continue;
            }
            bounds.addAll(e.getValue());
        }
        return bounds;
    }

    @SubscribeEvent
    public static void drawing(GuiScreenEvent.DrawScreenEvent.Post event) {
        if (!JEIAreaFixerConfig.debug$drawing || !(event.getGui() instanceof GuiContainer guiContainer)) {
            return;
        }
        if (!JEIAreaFixerConfig.debug$drawAll) {
            capturedAreas = collectActiveBounds(guiContainer.getClass());
        }
        for (Rectangle area : capturedAreas) {
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
