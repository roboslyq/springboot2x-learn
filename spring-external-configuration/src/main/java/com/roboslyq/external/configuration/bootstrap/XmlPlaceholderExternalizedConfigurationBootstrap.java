package com.roboslyq.external.configuration.bootstrap;

import com.roboslyq.external.configuration.entity.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author roboslyq
 * @data 2019/1/3 23:20
 * @desc :
 **/
@ImportResource("META-INF/spring/user-context.xml") // 加载 Spring 上下文 XML 文件
@EnableAutoConfiguration
public class XmlPlaceholderExternalizedConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new
                        SpringApplicationBuilder(XmlPlaceholderExternalizedConfigurationBootstrap.class)
                        .web( WebApplicationType.NONE) // 非 Web 应用
                        .run(args);
        User user = context.getBean("user", User.class);
        System.out.println("用户对象 : " + user);
// 关闭上下文
        context.close();
    }
}