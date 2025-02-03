package zzzank.mod.jei_area_fixer.mixin.appliedenergistics2;

import appeng.client.gui.implementations.GuiMEMonitorable;
import appeng.container.implementations.ContainerMEMonitorable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiMEMonitorable.class, remap = false)
public interface AccessGuiMEMonitorable {

    @Accessor("viewCell")
    boolean jaf$viewCell();

    @Accessor("monitorableContainer")
    ContainerMEMonitorable jaf$monitorableContainer();
}
