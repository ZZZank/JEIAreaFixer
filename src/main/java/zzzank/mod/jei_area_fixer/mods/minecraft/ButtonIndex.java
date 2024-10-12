package zzzank.mod.jei_area_fixer.mods.minecraft;

import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.GuiButton;
import vazkii.quark.management.client.gui.GuiButtonChest;
import xzeroair.trinkets.client.gui.TrinketGuiButton;

import java.util.function.Supplier;

/**
 * @author ZZZank
 */
public class ButtonIndex<T extends GuiButton> {

    private static int currentOrdinal = 0;

    public static final ButtonIndex<GuiButtonChest> QUARK = register(() -> GuiButtonChest.class);
    public static final ButtonIndex<GuiButtonInventoryTab> RESKILLABLE = register(() -> GuiButtonInventoryTab.class);
    public static final ButtonIndex<GuiButton> AE2 = register(null);
    public static final ButtonIndex<SkyTab> BLUE_SKIES = register(()-> SkyTab.class);
    public static final ButtonIndex<GuiTweakButton> CRAFTING_TWEAKS = register(() -> GuiTweakButton.class);
    public static final ButtonIndex<TrinketGuiButton> TRINKET = register(() -> TrinketGuiButton.class);

    public static <T extends GuiButton> ButtonIndex<T> register(Supplier<Class<T>> type) {
        return new ButtonIndex<>(type, currentOrdinal++);
    }

    public final Supplier<Class<T>> typeProvider;
    public final int index;

    private ButtonIndex(Supplier<Class<T>> typeProvider, int ordinal) {
        this.typeProvider = typeProvider;
        this.index = ordinal;
    }
}
