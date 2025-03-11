package zzzank.mod.jei_area_fixer.mods.minecraft;

import appeng.client.gui.widgets.GuiImgButton;
import appeng.client.gui.widgets.GuiTabButton;
import appeng.client.gui.widgets.GuiToggleButton;
import codersafterdark.reskillable.client.gui.button.GuiButtonInventoryTab;
import com.legacy.blue_skies.client.gui.tabs.SkyTab;
import mustapelto.deepmoblearning.client.gui.buttons.ButtonRedstoneMode;
import net.blay09.mods.craftingtweaks.client.GuiTweakButton;
import net.minecraft.client.gui.GuiButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiImgButtonBooster;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiItemIconButton;
import p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTrashButton;
import p455w0rd.wct.client.gui.widgets.GuiImgButtonMagnetMode;
import p455w0rd.wct.client.gui.widgets.GuiImgButtonShiftCraft;
import vazkii.quark.management.client.gui.GuiButtonChest;
import xzeroair.trinkets.client.gui.TrinketGuiButton;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author ZZZank
 */
public final class ButtonIndex<T extends GuiButton> {

    private static int currentOrdinal = 0;
    public static final ButtonIndex<GuiButtonChest> QUARK = register((b) -> b instanceof GuiButtonChest);
    public static final ButtonIndex<GuiButtonInventoryTab> RESKILLABLE = register((b) -> b instanceof GuiButtonInventoryTab);
    public static final ButtonIndex<GuiButton> AE2 = register((b) ->
        b instanceof GuiImgButton
        || b instanceof GuiTabButton
        || b instanceof GuiToggleButton
    );
    public static final ButtonIndex<SkyTab> BLUE_SKIES = register((b) -> b instanceof SkyTab);
    public static final ButtonIndex<GuiTweakButton> CRAFTING_TWEAKS = register((b) -> b instanceof GuiTweakButton);
    public static final ButtonIndex<TrinketGuiButton> TRINKET = register((b) -> b instanceof TrinketGuiButton);
    public static final ButtonIndex<GuiButton> AE2WT_LIB = register((b) ->
        //from AE2WTLib
        b instanceof p455w0rd.ae2wtlib.api.client.gui.widgets.GuiTabButton ||
        b instanceof GuiTrashButton ||
        b instanceof GuiItemIconButton ||
        //from AE2
        b instanceof GuiImgButton ||
        b instanceof GuiToggleButton
    );
    public static final ButtonIndex<GuiButton> WIRELESS_CRAFTING_TERMINAL = register((b) ->
        b instanceof GuiImgButtonBooster ||
        b instanceof GuiImgButtonMagnetMode ||
        b instanceof GuiImgButtonShiftCraft
    );
    public static final ButtonIndex<ButtonRedstoneMode> DME_REDSTONE = register((b) -> b instanceof ButtonRedstoneMode);

    public final Predicate<GuiButton> filter;
    public final Integer index;

    private ButtonIndex(Predicate<GuiButton> filter, int index) {
        this.filter = filter;
        this.index = index;
    }

    private static <T extends GuiButton> ButtonIndex<T> register(Predicate<GuiButton> predicate) {
        return new ButtonIndex<>(Objects.requireNonNull(predicate), currentOrdinal++);
    }
}
