package com.roboslyq.autoconfiguration.autoconfiguration;

import com.roboslyq.autoconfiguration.condition.service.ConditionalHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author roboslyq
 * @data 2018/12/31 10:22
 * @desc :
 **/
@EnableAutoConfiguration
public class AutoconfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
        new SpringApplicationBuilder( AutoconfigurationBootstrap.class )
                .web( WebApplicationType.NONE )
                .run( args );
        String helloWorld = configurableApplicationContext.getBean( "helloWorld",String.class );
        System.out.println(helloWorld);
        configurableApplicationContext.close();
    }
}
