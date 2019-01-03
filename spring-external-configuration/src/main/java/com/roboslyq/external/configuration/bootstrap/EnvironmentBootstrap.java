package com.roboslyq.external.configuration.bootstrap;

import com.roboslyq.external.configuration.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author roboslyq
 * @data 2019/1/3 23:58
 * @desc :
 **/
@EnableAutoConfiguration
public class EnvironmentBootstrap implements ApplicationContextAware {
    private Environment environment;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.environment = applicationContext.getEnvironment();
    }

    @Bean
    private User user(){
        User user = new User();
        user.setAge( Long.valueOf( environment.getProperty("user.age") ));
        user.setId( Long.valueOf( environment.getProperty("user.id") ));
        user.setName( environment.getProperty("user.name") );
        return user;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(EnvironmentBootstrap.class)
                        .web( WebApplicationType.NONE) // 非 Web 应用
                        .run(args);
        User user = context.getBean("user", User.class);
        System.out.println("用户对象 : " + user);
// 关闭上下文
        context.close();
    }
}

