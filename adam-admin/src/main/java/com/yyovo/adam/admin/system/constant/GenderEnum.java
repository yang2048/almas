package com.yyovo.adam.admin.system.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yyovo.adam.common.handler.ApiRuntimeException;
import com.yyovo.adam.common.handler.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.implementation.bytecode.Throw;

@AllArgsConstructor
@Getter
@ToString
public enum GenderEnum {
    unknown(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    private final int code;
    @JsonValue
    private final String desc;

    public static GenderEnum convert(String genderValue){
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.desc.equals(genderValue)) {
                return gender;
            }
        }
        throw new ApiRuntimeException(ErrorType.ENUM_NOT_VALID);
    }

}
