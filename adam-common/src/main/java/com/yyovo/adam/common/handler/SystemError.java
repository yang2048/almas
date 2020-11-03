package com.yyovo.adam.common.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemError implements IErrorType {

    SYSTEM_ERROR(-1, "系统异常"),
    SYSTEM_BUSY(500, "系统繁忙,请稍候再试"),
    ARG_ERROR(10001, "参数异常"),
    SYSTEM_CONVERT(10002, "数据转换错误");

    /**
     * 错误类型码
     */
    private final int code;
    /**
     * 错误类型描述信息
     */
    private final String msg;
}
