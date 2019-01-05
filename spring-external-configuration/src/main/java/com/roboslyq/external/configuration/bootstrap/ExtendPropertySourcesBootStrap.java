package com.roboslyq.external.configuration.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Properties;

/**
 * @author roboslyq
 * @data 2019/1/5 17:54
 * @desc :
 **/
@EnableAutoConfiguration
@PropertySource(name ="from-@PropertySource",value = "classpath:META-INF/default.properties")
public class ExtendPropertySourcesBootStrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ExtendPropertySourcesBootStrap.class  )
                //default properties
              .properties( "user.id=99" )
                //Profile-specific application properties
                .profiles( "dev" )
                .web( WebApplicationType.NONE )
                // command Line Arguments
                .run( argsOf("--user.id=9") );
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.printf("用户ID: %d \n",environment.getProperty( "user.id" ,Long.class));

        environment.getPropertySources().forEach( propertySource -> {
            System.out.printf("PropertySource[名称:%s] :\n %s \n",propertySource.getName(),propertySource);
            System.out.println("");
        } );
        context.close();
    }

    private static<T> T[] argsOf(T ... args){
        return args;
    }
}
