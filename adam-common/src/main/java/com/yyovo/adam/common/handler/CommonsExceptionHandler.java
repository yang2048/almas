package com.yyovo.adam.common.handler;

import com.yyovo.adam.common.base.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.stream.Collectors;

/**
 * @Copyright yang2048@qq.com @沐之永
 * @Company
 * @Author: YangYong
 * @Date: 2018/10/7 18:03
 * @Description: 异常处理
 */
@Slf4j
//@ControllerAdvice
@RestControllerAdvice
public class CommonsExceptionHandler {

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Result.failed(message);
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return Result.failed(message);
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Result.failed(message);
    }

    @ExceptionHandler(ApiRuntimeException.class)
    Result<?> apiRuntimeException(ApiRuntimeException e) {
        log.debug("错误码:{} 描述:{} ", e.getErrorType().getCode(), e.getErrorType().getMsg(), e);
        return Result.failed(e.getErrorType().getMsg());
    }

    /**
     * 自定义异常捕获
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Result commonsRuntimeException(Exception e) {
        return Result.failed(e.getMessage());
    }

}
