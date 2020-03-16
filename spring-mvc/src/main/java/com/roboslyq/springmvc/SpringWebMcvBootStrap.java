package com.roboslyq.springmvc;

import com.roboslyq.springmvc.filter.FilterDemo2;
import com.roboslyq.springmvc.listener.MyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author luo.yongqian
 */
@SpringBootApplication
@EnableWebMvc
public class SpringWebMcvBootStrap {

    @Bean
    @Autowired
    public FilterRegistrationBean registration() {
        FilterDemo2 filter = new FilterDemo2();
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(true);
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("filterDemo3");
        registration.setOrder(6);
        return registration;
    }
    @Bean
    @Autowired
    public ServletListenerRegistrationBean registrationListener(MyListener listener) {
        ServletListenerRegistrationBean registration = new ServletListenerRegistrationBean(listener);
        registration.setEnabled(true);
        return registration;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringWebMcvBootStrap.class,args);
        ApplicationContext applicationContext = configurableApplicationContext.getParent();
        System.out.println(applicationContext);
    }
}
