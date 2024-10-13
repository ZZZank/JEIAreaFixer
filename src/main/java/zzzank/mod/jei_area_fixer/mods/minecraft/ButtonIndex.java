package zzzank.mod.jei_area_fixer.mods.minecraft;

import appeng.client.gui.widgets.GuiImgButton;
import appeng.client.gui.widgets.GuiTabButton;
import appeng.client.gui.widgets.GuiToggleButton;
import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import lombok.val;
import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiItemIconButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTrashButton;
import vazkii.quark.management.client.gui.GuiButtonChest;
import xzeroair.trinkets.client.gui.TrinketGuiButton;

import java.util.function.Predicate;

/**
 * @author ZZZank
 */
public class ButtonIndex<T extends GuiButton> {

    private static int currentOrdinal = 0;
    public static final ButtonIndex<GuiButtonChest> QUARK = register(() -> GuiButtonChest.class);
    public static final ButtonIndex<GuiButtonInventoryTab> RESKILLABLE = register(() -> GuiButtonInventoryTab.class);
    public static final ButtonIndex<GuiButton> AE2 = registerMulti(() -> arr(
        GuiImgButton.class,
        GuiTabButton.class,
        GuiToggleButton.class
    ));
    public static final ButtonIndex<SkyTab> BLUE_SKIES = register(() -> SkyTab.class);
    public static final ButtonIndex<GuiTweakButton> CRAFTING_TWEAKS = register(() -> GuiTweakButton.class);
    public static final ButtonIndex<TrinketGuiButton> TRINKET = register(() -> TrinketGuiButton.class);
    public static final ButtonIndex<GuiButton> AE2WT_LIB = registerMulti(() -> arr(
        p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTabButton.class,
        GuiTrashButton.class,
        GuiItemIconButton.class
    ));

    public final Predicate<GuiButton> filter;
    public final int index;

    private ButtonIndex(Predicate<GuiButton> filter, int index) {
        this.filter = filter;
        this.index = index;
    }

    public static <T extends GuiButton> ButtonIndex<T> register(Supplier<Class<T>> type) {
        return new ButtonIndex<>((b) -> type.get().isInstance(b), currentOrdinal++);
    }

    public static <T extends GuiButton> ButtonIndex<T> registerMulti(Supplier<Class<? extends T>[]> types) {
        val cachedTypes = Suppliers.memoize(types);
        return new ButtonIndex<>(b -> {
            for (val type : cachedTypes.get()) {
                if (type.isInstance(b)) {
                    return true;
                }
            }
            return false;
        }, currentOrdinal);
    }

    @SuppressWarnings("unchecked")
    private static <T extends GuiButton> Class<? extends T>[] arr(Class<? extends T>... buttons) {
        return buttons;
    }
}
