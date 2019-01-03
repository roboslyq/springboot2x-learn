package com.roboslyq.springboot2xlearn.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author roboslyq
 * @data 2018/12/30 0:36
 * @desc :
 **/
@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized（）监听事件源-->"+sce.toString());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed（）监听事件源-->"+sce.toString());
    }
}
