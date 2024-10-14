package zzzank.mod.jei_area_fixer.mixin.appliedenergistics2;

import appeng.client.gui.implementations.GuiMEMonitorable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.applied_energistics_2.GuiMEMonitorableAccessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiMEMonitorable.class, remap = false)
public interface AccessGuiMEMonitorable extends GuiMEMonitorableAccessor {

    @Accessor("viewCell")
    @Override
    boolean jaf$viewCell();
}
