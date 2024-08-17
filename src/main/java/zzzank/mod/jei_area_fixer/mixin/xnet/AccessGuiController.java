package zzzank.mod.jei_area_fixer.mixin.xnet;

import mcjty.lib.base.ModBase;
import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.widgets.WidgetList;
import mcjty.xnet.blocks.controller.TileEntityController;
import mcjty.xnet.blocks.controller.gui.GuiController;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.jei_area_fixer.mods.xnet.GuiControllerAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiController.class)
public abstract class AccessGuiController
    extends GenericGuiContainer<TileEntityController>
    implements GuiControllerAccessor {

    @Accessor(value = "connectorList", remap = false)
    public abstract WidgetList get$connectorList();

    private AccessGuiController(
        ModBase mod,
        SimpleNetworkWrapper network,
        TileEntityController tileEntity,
        Container container,
        int manual,
        String manualNode
    ) {
        super(mod, network, tileEntity, container, manual, manualNode);
    }
}
