package com.roboslyq.autoconfiguration.enable.configuration;

import com.roboslyq.autoconfiguration.enable.configuration.HelloworldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author roboslyq
 * @data 2018/12/31 11:02
 * @desc :
 **/
public class HelloworldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloworldConfiguration.class.getName()};
    }
}
