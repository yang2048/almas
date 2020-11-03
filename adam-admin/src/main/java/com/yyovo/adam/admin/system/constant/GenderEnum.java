package com.yyovo.adam.admin.system.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    GenderEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private final int code;

    private final String desc;

    @JsonValue
    @Override
    public String toString() {
        return desc;
    }
}
