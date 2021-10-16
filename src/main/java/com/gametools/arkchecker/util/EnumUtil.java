package com.gametools.arkchecker.util;

import com.gametools.arkchecker.domain.dto.EnumValue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumUtil {
    private EnumUtil() {
    }

    public static List<EnumValue> toEnumValues(Class<? extends EnumModel> e) {
        return Arrays.stream(e.getEnumConstants())
            .map(EnumValue::new)
            .collect(Collectors.toList());
    }
}
