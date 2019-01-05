package com.roboslyq.external.configuration.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roboslyq
 * @data 2019/1/5 21:58
 * @desc :
 **/
public class ExtendPropertySourceEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> source = new HashMap<>();
        source.put( "user.id","12" );
        PropertySource<Map<String, Object>> propertySource = new MapPropertySource( "from-EnvironmentPostProcessor",source );
        propertySources.addFirst( propertySource );
    }
}
