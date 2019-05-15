package com.roboslyq.webflux.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 *指定mapper的扫描包路径，若不指定可能会加载不了相应的mapper从而导致数据库操作报错
 * 此注解放在{@link @Configuration}配置类或者引导类{@link SpringBootApplication}中均可以
 */
@MapperScan("com.roboslyq.webflux.mapper")
public class MybatisPlusConfig {
}
