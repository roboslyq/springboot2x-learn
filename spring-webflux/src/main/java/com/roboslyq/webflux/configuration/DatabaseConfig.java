package com.roboslyq.webflux.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    /**
     * 根据 application.yml中的配置文件中参数进行数据源配置。如果不配置数据源启动系统会报如下异常：
     * Description:
     * Failed to configure a DataSource:
     *          'url' attribute is not specified and no embedded datasource could be configured.
     * Reason: Failed to determine a suitable driver class
     */
    //设置为默认数据源
    @Primary
    @Bean(name = "dataSourcePrimary")
    //数据源参数前缀
    @ConfigurationProperties(prefix = "spring.datasource.webflux")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
