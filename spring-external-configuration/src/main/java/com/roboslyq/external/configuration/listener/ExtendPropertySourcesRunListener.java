package com.roboslyq.external.configuration.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roboslyq
 * @data 2019/1/5 17:38
 * @desc :
 **/
public class ExtendPropertySourcesRunListener implements SpringApplicationRunListener,Ordered {
    private final SpringApplication application;

    private final String[] args;

    public ExtendPropertySourcesRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        //永远EventPublishingRunListener之后执行
        (new EventPublishingRunListener( this.application, this.args )).getOrder();
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
       MutablePropertySources mutablePropertySources = environment.getPropertySources();
        Map<String,Object> propertyMap = new HashMap<>();
        propertyMap.put( "user.id",0 );
        PropertySource propertySource = new MapPropertySource( "from-RunListener-environmentPrepared",propertyMap);
        mutablePropertySources.addFirst( propertySource );
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources mutablePropertySources = environment.getPropertySources();
        Map<String,Object> propertyMap = new HashMap<>();
        propertyMap.put( "user.id",14 );
        PropertySource propertySource = new MapPropertySource( "from-RunListener-contextPrepared",propertyMap);
        mutablePropertySources.addFirst( propertySource );
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources mutablePropertySources = environment.getPropertySources();
        Map<String,Object> propertyMap = new HashMap<>();
        propertyMap.put( "user.id",15 );
        PropertySource propertySource = new MapPropertySource( "from-RunListener-contextLoaded",propertyMap);
        mutablePropertySources.addFirst( propertySource );
    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
