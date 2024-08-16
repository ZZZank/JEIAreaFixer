package zzzank.mod.bookmark_area_fixer.mixin.xnet;

import mcjty.lib.base.ModBase;
import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.widgets.Panel;
import mcjty.lib.gui.widgets.WidgetList;
import mcjty.xnet.blocks.controller.TileEntityController;
import mcjty.xnet.blocks.controller.gui.GuiController;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import zzzank.mod.bookmark_area_fixer.mods.xnet.GuiContainerAccessor;

/**
 * @author ZZZank
 */
@Mixin(GuiController.class)
public abstract class AccessGuiController
    extends GenericGuiContainer<TileEntityController>
    implements GuiContainerAccessor {

    @Accessor(value = "channelEditPanel", remap = false)
    public abstract Panel jeiArea$channelEditPanel();

    @Accessor(value = "connectorList", remap = false)
    public abstract WidgetList jeiArea$connectorList();

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
