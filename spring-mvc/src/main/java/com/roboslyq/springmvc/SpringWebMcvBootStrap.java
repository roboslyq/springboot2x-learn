package com.roboslyq.springmvc;

import com.roboslyq.springmvc.filter.MyFilter;
import com.roboslyq.springmvc.listener.MyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWebMcvBootStrap {

    @Bean
    @Autowired
    public FilterRegistrationBean registration() {
        MyFilter filter = new MyFilter();
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
        SpringApplication.run(SpringWebMcvBootStrap.class,args);
    }
}
