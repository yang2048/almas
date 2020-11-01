package com.yyovo.adam.core.handler;

import com.yyovo.adam.common.base.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
// 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
// 然后提取错误提示信息进行返回
        return objectError.getDefaultMessage();
    }

    /**
     * 参数提交异常捕获
     * @param bindException
     * @return ResponseDTO
     */
//    @ExceptionHandler(value = BindException.class)
//    public ResponseDTO handlerBindException(BindException bindException) {
//        BindingResult result = bindException.getBindingResult();
//        List<ObjectError> errors = result.getAllErrors();
//        StringBuilder sb = new StringBuilder();
//        sb.append("参数校验警告：");
//        errors.forEach(p -> {
//            FieldError fieldError = (FieldError) p;
//            log.warn("参数校验警告==> 对象:{}, 字段:{}, 提示信息:{}",
//                    fieldError.getObjectName(),fieldError.getField(),fieldError.getDefaultMessage());
//            sb.append("["+fieldError.getDefaultMessage()+"]");
//        });
////        return ResponseDTO.error(StatusCode.RTN_CODE_UNKNOW_ERROR, sb.toString());
//        return ResponseEntity.status(HttpStatus.OK).body(Result.failed(bindException.getMessage()));
//    }

    @ExceptionHandler(ApiRuntimeException.class)
    ResponseEntity apiRuntimeException(ApiRuntimeException e) {
        StringWriter stringWriter= new StringWriter();
//        PrintWriter writer= new PrintWriter(stringWriter);
//        e.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        log.info("====================== " + e.getErrorType().getMsg() + " ======================"  );
        log.info(buffer.toString());
        return ResponseEntity.status(HttpStatus.OK).body(Result.failed(e.getErrorType().getMsg()));
    }

    /**
     * 自定义异常捕获
     * @param e
     * @return
     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = Exception.class)
//    public ResponseDTO commonsRuntimeException(Exception e) {
//        if (e instanceof ApiRuntimeException) {
//            ApiRuntimeException runtimeException = (ApiRuntimeException) e;
//            //log.warn("【自定义异常】 => rspCode: {}， rspMsg: {}", runtimeException.getCode(), runtimeException.getMessage());
//            return ResponseDTO.error(runtimeException.getCode(),runtimeException.getMessage());
//        } else {
//            //TODO 邮件通知
//            log.error("【系统异常】 => rspCode:{},错误信息为：", StatusCode.RTN_CODE_UNKNOW_ERROR, e);
//            return ResponseDTO.error(StatusCode.RTN_CODE_UNKNOW_ERROR, e.getMessage(), stackTraceToString(e));
//        }
//    }

    /**
     * @param e
     * @return
     * @description 将异常堆栈转成string
     */
    private static String stackTraceToString(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
