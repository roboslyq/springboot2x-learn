package com.roboslyq.autoconfiguration.repository.annotation;

import java.lang.annotation.*;

/**
 * @author roboslyq
 * @data 2018/12/31 10:15
 * @desc :
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@FirstRepository
public @interface SecondRepository {
    String value() default "";
}
