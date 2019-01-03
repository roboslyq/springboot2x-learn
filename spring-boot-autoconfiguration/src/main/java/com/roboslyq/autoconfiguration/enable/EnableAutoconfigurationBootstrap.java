package com.roboslyq.autoconfiguration.enable;

import com.roboslyq.autoconfiguration.enable.annotation.EnableHelloworld;
import com.roboslyq.autoconfiguration.enable.configuration.HelloworldConfiguration;
import com.roboslyq.autoconfiguration.repository.repository.SecondRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author roboslyq
 * @data 2018/12/31 10:22
 * @desc :
 **/
@EnableHelloworld
public class EnableAutoconfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
        new SpringApplicationBuilder( EnableAutoconfigurationBootstrap.class )
                .web( WebApplicationType.NONE )
                .run( args );
        String helloWorld = configurableApplicationContext
                .getBean("helloWorld",String.class);
        System.out.println("helloWorld ----->" + helloWorld);
        configurableApplicationContext.close();
    }
}
