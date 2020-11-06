package com.yyovo.adam.common.aspect.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {
    /**
     * 日志描述
     *
     */
    String value() default "";

    /**
     * 日志类型
     *
     * @return 1:操作日志; 2:登录日志; 3:定时任务;
     */
    int logType() default 1;

    /**
     * 操作日志类型
     *
     * @return 1查询 2修改 3添加 4删除
     */
    int operateType() default 0;
}
