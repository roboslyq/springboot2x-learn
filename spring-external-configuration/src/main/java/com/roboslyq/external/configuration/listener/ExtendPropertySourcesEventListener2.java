package com.roboslyq.external.configuration.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roboslyq
 * @data 2019/1/5 21:41
 * @desc :
 **/
public class ExtendPropertySourcesEventListener2 implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableEnvironment environment =   event.getApplicationContext().getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> source = new HashMap<>();
        source.put( "user.id","16" );
        PropertySource<Map<String, Object>> propertySource = new MapPropertySource( "from-ApplicationListener<ApplicationPreparedEvent>",source );
        propertySources.addFirst( propertySource );
    }
}
