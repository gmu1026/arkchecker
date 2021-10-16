package com.gametools.arkchecker.domain;

import com.gametools.arkchecker.util.EnumModel;

public enum ContentsType implements EnumModel {
    DAILY("일일"),
    WEEKLY("주간"),
    EXPEDITION("원정대");

    private final String value;

    ContentsType(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
