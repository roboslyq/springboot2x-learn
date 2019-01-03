package com.roboslyq.external.configuration.bootstrap;

import com.roboslyq.external.configuration.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roboslyq
 * @data 2019/1/3 23:01
 * @desc :
 **/
public class SpringXmlConfigPlaceholderBootstrap {
    public static void main(String[] args) {
        String[] locations = {"META-INF/spring/spring-context.xml", "META-INF/spring/user-context.xml"};
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext( locations );
        User user = applicationContext.getBean( "user", User.class );
        System.out.println( "用户对象 : " + user );
// 关闭上下文
        applicationContext.close();
    }
}