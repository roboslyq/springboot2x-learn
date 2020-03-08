package com.roboslyq.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(  );
        Set<String> sources = new HashSet<String>(  );
        sources.add( SpringbootApplication.class.getName() );

        springApplication.setSources(sources);
        springApplication.setWebApplicationType( WebApplicationType.SERVLET );
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run( args );
        SpringbootApplication springbootApplication = configurableApplicationContext.getBean(SpringbootApplication.class);
        System.out.println("Bean -- " + springApplication);
        System.out.println("parent--"+configurableApplicationContext.getParent());
        System.out.println(configurableApplicationContext);
    }
}

