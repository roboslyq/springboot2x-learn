package com.roboslyq.autoconfiguration.enable.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author roboslyq
 * @data 2018/12/31 10:52
 * @desc :
 **/
@Configuration
public class HelloworldConfiguration {
    @Bean
    public String helloWorld(){
        return "hello world";
    }
}
