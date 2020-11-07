package com.yyovo.adam.common.aspect;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.yyovo.adam.common.aspect.annotation.ApiLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
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
    public Object around(ProceedingJoinPoint point) throws Throwable {
        TimeInterval timer = DateUtil.timer();

        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
        System.out.println("EXECUTION 调用方法:" + point.getSignature().getName());

        Iterator it = Arrays.stream(point.getArgs()).iterator();
        StringBuilder sb = new StringBuilder();
        it.forEachRemaining(i -> sb.append(i));
        System.out.println("EXECUTION 参数：" + sb);
//        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());

        MethodSignature signature = (MethodSignature) point.getSignature();
        ApiLog apiLog = signature.getMethod().getAnnotation(ApiLog.class);
        System.out.println("ANNOTATION welcome==>"+ apiLog.value());



        //获取request
//        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();

        //保存日志
//        saveSysLog(point, time, result);

        Object ob = point.proceed();

        long time = timer.intervalRestart();
        System.out.println("时间 ==>"+ time);
        return ob;
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
