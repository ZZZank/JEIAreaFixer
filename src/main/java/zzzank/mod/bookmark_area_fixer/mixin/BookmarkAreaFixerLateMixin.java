package zzzank.mod.bookmark_area_fixer.mixin;

import zone.rong.mixinbooter.ILateMixinLoader;
import zzzank.mod.bookmark_area_fixer.Tags;
import zzzank.mod.bookmark_area_fixer.mods.ModState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
public class BookmarkAreaFixerLateMixin implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Arrays
            .stream(Tags.MIXIN_CONFIGS.split(" "))
            .filter(ModState::loaded)
            .map(id -> String.format(Tags.MIXIN_CONFIG_FORMAT, id))
            .collect(Collectors.toList());
    }
}
