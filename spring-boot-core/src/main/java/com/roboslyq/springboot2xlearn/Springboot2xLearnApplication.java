package com.roboslyq.springboot2xlearn;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.roboslyq.springboot2xlearn.web.servlet")
public class Springboot2xLearnApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Springboot2xLearnApplication.class )
//                .main( )
                .web( WebApplicationType.SERVLET )
                .run( args );
//        SpringApplication.run( Springboot2xLearnApplication.class, args );
    }

}

