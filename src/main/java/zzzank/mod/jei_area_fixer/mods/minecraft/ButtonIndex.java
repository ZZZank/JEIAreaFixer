package zzzank.mod.jei_area_fixer.mods.minecraft;

import net.minecraft.client.gui.GuiButton;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author ZZZank
 */
public final class ButtonIndex<T extends GuiButton> {

    private static final AtomicInteger currentOrdinal = new AtomicInteger();

    public final Predicate<GuiButton> filter;
    public final Integer index;

    private ButtonIndex(Predicate<GuiButton> filter, int index) {
        this.filter = filter;
        this.index = index;
    }

    public synchronized static <T extends GuiButton> ButtonIndex<T> register(Predicate<GuiButton> predicate) {
        return new ButtonIndex<>(Objects.requireNonNull(predicate), currentOrdinal.incrementAndGet());
    }
}
