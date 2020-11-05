package com.yyovo.adam.admin.system.constant;

import com.yyovo.adam.common.handler.IErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemError implements IErrorType {

    SYSTEM_ERROR(-1, "系统异常");

    /**
     * 错误类型码
     */
    private final int code;
    /**
     * 错误类型描述信息
     */
    private final String msg;
}
