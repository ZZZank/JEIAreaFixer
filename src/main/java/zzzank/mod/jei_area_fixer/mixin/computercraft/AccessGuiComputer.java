package zzzank.mod.jei_area_fixer.mixin.computercraft;

import dan200.computercraft.client.gui.GuiComputer;
import dan200.computercraft.client.gui.widgets.WidgetTerminal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author ZZZank
 */
@Mixin(value = GuiComputer.class, remap = false)
public interface AccessGuiComputer {

    @Accessor("m_terminal")
    WidgetTerminal jaf$terminal();
}
