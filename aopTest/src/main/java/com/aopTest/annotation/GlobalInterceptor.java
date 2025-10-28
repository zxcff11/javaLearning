package com.aopTest.annotation;

import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GlobalInterceptor {
    boolean checkValue() default false;
}
