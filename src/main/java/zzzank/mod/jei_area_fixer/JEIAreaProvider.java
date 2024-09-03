package zzzank.mod.jei_area_fixer;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

/**
 * for mixin usage
 * @author ZZZank
 */
public interface JEIAreaProvider {

    @Nullable
    List<Rectangle> jei_area_fixer$getAreas();
}
