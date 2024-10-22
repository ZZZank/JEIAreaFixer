package zzzank.mod.jei_area_fixer.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ZZZank
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameUtils {
    public static final Pattern UPPER_CASES = Pattern.compile("(_?[A-Z]+)");

    public static String titleToSplitTitle(String title) {
        return Arrays.stream(UPPER_CASES.matcher(title)
                .replaceAll("_$1")
                .split("_")
            )
            .map(s -> s.isEmpty()
                ? s
                : s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1)
            )
            .collect(Collectors.joining(" "));
    }
}
