package com.yyovo.adam.admin.system.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
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

}
