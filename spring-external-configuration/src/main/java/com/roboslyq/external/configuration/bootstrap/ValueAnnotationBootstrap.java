package com.roboslyq.external.configuration.bootstrap;

import com.roboslyq.external.configuration.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author roboslyq
 * @data 2019/1/3 23:58
 * @desc :
 **/
@EnableAutoConfiguration
public class ValueAnnotationBootstrap {
    

    @Bean
    private User user(@Value( "${user.name}" ) String userName,
                      @Value("${user.id}") Long userId,
                      @Value("${user.age}") Long userAge){
        User user = new User();
        user.setAge( userAge );
        user.setId( userId );
        user.setName( userName );
        return user;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ValueAnnotationBootstrap.class)
                        .web( WebApplicationType.NONE) // 非 Web 应用
                        .run(args);
        User user = context.getBean("user", User.class);
        System.out.println("用户对象 : " + user);
// 关闭上下文
        context.close();
    }
}

