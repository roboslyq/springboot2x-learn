package com.roboslyq.webflux.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    //执行yml配置文件中的test2 数据源
    @Primary
    @Bean(name = "dataSourcePrimary")
    @ConfigurationProperties(prefix = "spring.datasource.webflux")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
