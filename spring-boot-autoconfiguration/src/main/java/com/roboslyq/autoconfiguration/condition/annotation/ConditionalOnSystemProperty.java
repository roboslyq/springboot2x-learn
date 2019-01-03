package com.roboslyq.autoconfiguration.condition.annotation;

import com.roboslyq.autoconfiguration.condition.condition.OnSystemPropertyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author roboslyq
 * @data 2018/12/31 21:13
 * @desc :
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name();
    String value();
}
