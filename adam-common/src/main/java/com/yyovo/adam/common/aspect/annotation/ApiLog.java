package com.yyovo.adam.common.aspect.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
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
     * @return 1查询 2添加 3修改 4删除
     */
    int operateType() default 0;
}
