package com.gametools.arkchecker.domain.dto;

import com.gametools.arkchecker.util.EnumModel;
import lombok.Getter;

@Getter
public class EnumValue {
    private final String name;
    private final String value;

    public EnumValue(EnumModel enumModel) {
        this.name = enumModel.getName();
        this.value = enumModel.getValue();
    }
}
