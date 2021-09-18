package mayfly.core.log;

import java.lang.annotation.*;

/**
 * 可用于类和方法，用于类则该类的方法都会记录日志 <br/>
 * 如果方法和类都有该注解，result和time属性则使用方法级的注解属性描述，而value信息则为两则相加 </br>
 * 如果方法的返回值为void则不记录返回结果
 *
 * @author meilin.huang
 * @version 1.0
 * @date 2018-11-06 10:41 AM
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 日志描述description,如果类和方法该值都为空，则不会有该项日志记录
     */
    String value() default "";

    /**
     * 是否记录返回结果，默认true
     */
    boolean res() default true;

    /**
     * 打印日志的级别，默认info级别
     */
    LogLevel level() default LogLevel.INFO;

    /**
     * 只有日志级别为该级别时，才会打印方法返回结果（用于灵活控制避免打印很大的结果列表等）
     */
    LogLevel resLevel() default LogLevel.INFO;

    /**
     * 打印日志的级别
     */
    enum LogLevel {
        /**
         * 不打印日志
         */
        NONE(0),

        DEBUG(1),

        INFO(2),

        WARN(3),

        ERROR(4);

        private final int order;

        LogLevel(int order) {
            this.order = order;
        }

        public int order() {
            return this.order;
        }
    }
}

