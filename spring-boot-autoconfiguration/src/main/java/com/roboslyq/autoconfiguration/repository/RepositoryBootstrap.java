package com.roboslyq.autoconfiguration.repository;

import com.roboslyq.autoconfiguration.repository.repository.MyFirstRepository;
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
@ComponentScan(basePackages = "com.roboslyq.autoconfiguration.mapper")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
        new SpringApplicationBuilder( RepositoryBootstrap.class )
                .web( WebApplicationType.NONE )
                .run( args );
        SecondRepository secondRepository= configurableApplicationContext
                .getBean("secondRepository",SecondRepository.class);
        System.out.println("secondFirstRepository ----->" + secondRepository);
        configurableApplicationContext.close();
    }
}
