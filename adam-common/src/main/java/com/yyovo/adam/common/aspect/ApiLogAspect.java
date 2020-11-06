package com.yyovo.adam.common.aspect;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.yyovo.adam.common.aspect.annotation.ApiLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ApiLogAspect {

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.yyovo.adam.common.aspect.annotation.ApiLog)")
    public void logPointCut() {

    }

    /**
     * 环绕型增强通知
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        TimeInterval timer = DateUtil.timer();

        System.out.println("EXECUTION 调用方法:" + point.getSignature().getName());
        System.out.println("EXECUTION 目标对象：" + point.getTarget());
        System.out.println("EXECUTION 首个参数：" + point.getArgs()[0]);
        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        ApiLog apiLog = method.getAnnotation(ApiLog.class);
        System.out.println("ANNOTATION welcome==>"+ apiLog.value());

        //获取request
//        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        //返回花费时间，并重置开始时间
        long time = timer.intervalRestart();

        //保存日志
//        saveSysLog(point, time, result);

        point.proceed();
    }

    /**
     * 异常通知
     */
    @AfterThrowing(throwing="ex", pointcut="logPointCut()")
    public void doRecoveryActions(Throwable ex) {
        System.out.println("目标方法中抛出的异常:" + ex);
        System.out.println("模拟抛出异常后的增强处理...");
    }
}
