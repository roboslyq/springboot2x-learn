package com.roboslyq.autoconfiguration.repository.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
@Repository
public @interface FirstRepository {
    String value() default "";
}
