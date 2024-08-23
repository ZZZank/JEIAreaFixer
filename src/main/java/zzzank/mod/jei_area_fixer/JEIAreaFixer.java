package zzzank.mod.jei_area_fixer;

import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
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
     * @return null if provided null, otherwise a singleton list
     */
    @Nullable
    public static List<Rectangle> nullableWrap(@Nullable Rectangle rectangle) {
        return rectangle == null ? null : Collections.singletonList(rectangle);
    }
}
