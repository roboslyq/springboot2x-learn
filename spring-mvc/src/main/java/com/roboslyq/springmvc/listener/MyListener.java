package com.roboslyq.springmvc.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;

@Component
public class MyListener implements ServletContextListener {

    @Override
    public  void contextInitialized(ServletContextEvent sce) {
        System.err.println("servlet Context initailized .... ...");
    }

    @Override
    public  void contextDestroyed(ServletContextEvent sce) {
        System.err.println("servlet Context contextDestroyed .... ...");
    }
}
