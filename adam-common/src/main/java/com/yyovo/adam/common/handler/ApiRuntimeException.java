package com.yyovo.adam.common.handler;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApiRuntimeException extends RuntimeException implements Serializable {

    private ErrorType errorType;

    public ApiRuntimeException() {
        this.errorType = SystemError.SYSTEM_ERROR;
    }

    public ApiRuntimeException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ApiRuntimeException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ApiRuntimeException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }
}
