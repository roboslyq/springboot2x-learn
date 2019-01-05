package com.roboslyq.external.configuration.bootstrap;

import com.roboslyq.external.configuration.entity.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

/**
 * @author roboslyq
 * @data 2019/1/4 22:10
 * @desc :
 **/
@EnableAutoConfiguration
public class ConfigurationPropertiesBootStrap {
    @Bean
    @ConfigurationProperties(prefix = "user")
    @ConditionalOnProperty(name = "user.city.name")
    private User user(){
        return new User();
    }
    public static void main(String[] args) {
        Locale.setDefault( Locale.US );
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ConfigurationPropertiesBootStrap.class)
                        // 非 Web 应用
                        .web( WebApplicationType.NONE)
                        .run(args);
        User user = context.getBean( User.class);
        System.out.println("用户对象 : " + user);
        // 关闭上下文
        context.close();
    }
}
