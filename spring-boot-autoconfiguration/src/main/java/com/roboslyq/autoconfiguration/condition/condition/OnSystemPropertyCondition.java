package com.roboslyq.autoconfiguration.condition.condition;


import com.roboslyq.autoconfiguration.condition.annotation.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author roboslyq
 * @data 2018/12/31 21:16
 * @desc :
 **/
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String,Object> annotationAttributes =      metadata.getAnnotationAttributes( ConditionalOnSystemProperty.class.getName());
      String property = String.valueOf(annotationAttributes.get( "name" ));
      String value = String.valueOf(annotationAttributes.get( "value" ));
      String systemProperty = System.getProperty( property );
        System.out.println("系统参数 --"+System.getProperty( "user.name"));
      return  value.equals( System.getProperty( "user.name") );
//        return true;
    }
}
