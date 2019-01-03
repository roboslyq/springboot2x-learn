package com.roboslyq.autoconfiguration.condition;

import com.roboslyq.autoconfiguration.condition.annotation.ConditionalOnSystemProperty;
import com.roboslyq.autoconfiguration.condition.service.ConditionalHelloWorld;
import com.roboslyq.autoconfiguration.condition.service.SumService;
import com.roboslyq.autoconfiguration.enable.annotation.EnableHelloworld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author roboslyq
 * @data 2018/12/31 10:22
 * @desc :
 **/
@SpringBootApplication(scanBasePackages = "com.roboslyq.autoconfiguration.condition")
public class ConditionalBootstrap {
    public static void main(String[] args) {
        System.out.println(System.getProperty( "user.name" ));
        System.out.println(System.getProperty( "user.password" ));
        ConfigurableApplicationContext configurableApplicationContext =
        new SpringApplicationBuilder( ConditionalBootstrap.class )
                .web( WebApplicationType.NONE )
                .run( args );
        ConditionalHelloWorld conditionalHelloWorld = configurableApplicationContext.getBean( "conditionalHelloWorld",ConditionalHelloWorld.class );
        System.out.println(conditionalHelloWorld);
        configurableApplicationContext.close();
    }
}
