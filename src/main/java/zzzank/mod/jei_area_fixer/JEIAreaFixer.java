package zzzank.mod.jei_area_fixer;

import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * @author ZZZank
 */
@Mod(
    modid = Tags.MOD_ID,
    name = Tags.MOD_NAME,
    version = Tags.VERSION,
    dependencies = "after:jei@[4.16.0,);required-after:mixinbooter;",
    clientSideOnly = true
)
public class JEIAreaFixer {

    /**
     * @return singleton list if not null, otherwise an empty list
     */
    public static List<Rectangle> nullableWrap(Rectangle rectangle) {
        return rectangle == null ? Collections.emptyList() : Collections.singletonList(rectangle);
    }
}
