package com.roboslyq.thymeleaf.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;

@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
public class WebMvcConfig {
    @Bean
    public InternalResourceViewResolver defaultViewResolver()  {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE -6);
        return resolver;
    }
    @Bean
    /**
     * 解决Maven多模块下，在IDE环境中,JSP无法加载
     */
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer(){
        return  (factory)->{
          factory.addContextCustomizers(context ->{
              String relativePath = "spring-mvc-view/src/main/webapp";
              File file = new File(relativePath);
              if(file.exists()){
                  context.setDocBase(file.getAbsolutePath());
              }
          });
        };
    }
}
