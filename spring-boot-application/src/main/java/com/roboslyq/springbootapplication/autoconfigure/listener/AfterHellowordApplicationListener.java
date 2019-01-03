package com.roboslyq.springbootapplication.autoconfigure.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author roboslyq
 * @data 2019/1/1 10:47
 * @desc :
 **/
@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHellowordApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("最低优先级事件-->"+ event.getTimestamp()+"---"+event.getSource());

    }
}
