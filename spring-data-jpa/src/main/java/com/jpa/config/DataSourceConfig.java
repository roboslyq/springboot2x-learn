package com.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 *
 * @author luo.yongqian
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "primaryDS")
    @Qualifier("primaryDS")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource(){
       return DataSourceBuilder.create().type( com.alibaba.druid.pool.DruidDataSource.class ).build();
    }



    @Bean(name = "secondaryDS")
    @Qualifier("secondaryDS")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource(){
//        不使用druid
//        return DataSourceBuilder.create().build();
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class ).build();
    }
}
