package com.roboslyq.autoconfiguration.enable.annotation;

import com.roboslyq.autoconfiguration.enable.configuration.HelloworldImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author roboslyq
 * @data 2018/12/31 10:49
 * @desc :
 **/
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@Inherited
@Documented
//@Import( HelloworldConfiguration.class )
@Import( HelloworldImportSelector.class )
public @interface EnableHelloworld {
}
