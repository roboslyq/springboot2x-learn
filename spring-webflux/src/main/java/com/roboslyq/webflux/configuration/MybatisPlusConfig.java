package com.roboslyq.webflux.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.roboslyq.webflux.mapper")
public class MybatisPlusConfig {
}
