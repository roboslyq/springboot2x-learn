package com.roboslyq.thymeleaf.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.roboslyq.thymeleaf.web")
public class SpringbootViewBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootViewBootStrap.class,args);
    }
}
