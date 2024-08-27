package zzzank.mod.jei_area_fixer.mods.reskillable;

import java.awt.*;
import java.util.List;

/**
 * using a different name to prevent conflicts with {@link zzzank.mod.jei_area_fixer.JEIAreaProvider}
 * @author ZZZank
 */
public interface ReskillableAreasProvider {

    List<Rectangle> jei_area_fixer$getReskillableAreas();
}
