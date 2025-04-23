package zzzank.mod.jei_area_fixer.mixin;

import lombok.val;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import zone.rong.mixinbooter.ILateMixinLoader;
import zzzank.mod.jei_area_fixer.Tags;
import zzzank.mod.jei_area_fixer.mods.ModState;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
public class JEIAreaFixerLateMixin implements ILateMixinLoader, IMixinConfigPlugin {
    private static final String PACKAGE = JEIAreaFixerLateMixin.class.getPackage().getName() + '.';

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList(String.format(Tags.MIXIN_CONFIG_FORMAT, "mods"));
    }

    @Override
    public void onLoad(String s) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (!mixinClassName.startsWith(PACKAGE)) {
            return false;
        }
        val parts = mixinClassName.substring(PACKAGE.length()).split("\\.");
        switch (parts.length) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return ModState.loaded(parts[0]);
        }
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
