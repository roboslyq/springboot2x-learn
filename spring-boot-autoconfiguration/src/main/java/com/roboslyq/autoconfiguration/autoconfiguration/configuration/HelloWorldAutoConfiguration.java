package com.roboslyq.autoconfiguration.autoconfiguration.configuration;

import com.roboslyq.autoconfiguration.condition.annotation.ConditionalOnSystemProperty;
import com.roboslyq.autoconfiguration.enable.annotation.EnableHelloworld;
import org.springframework.context.annotation.Configuration;

/**
 * @author roboslyq
 * @data 2018/12/31 23:17
 * @desc :
 **/
@Configuration
@EnableHelloworld
@ConditionalOnSystemProperty( name ="user.name" ,value = "robos")
public class HelloWorldAutoConfiguration {
}
