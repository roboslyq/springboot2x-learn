/**
 * Copyright (C), 2015-2020
 * FileName: WebConfig
 * Author:   luo.yongqian
 * Date:     2020/3/14 17:26
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/14 17:26      1.0.0               创建
 */
package com.roboslyq.springmvc.config;

import com.roboslyq.springmvc.interceptor.InterceptorDemo1;
import com.roboslyq.springmvc.interceptor.InterceptorDemo2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * 〈
 * 1、Spring MVC配置类，WebMvcConfigurationSupport比较底层，包含很多默认配置，如果不是很
 * 清楚不建议直接继承此类。而是通过实现WebMvcConfigurer接口来完成配置扩展。
 * 2、此类配置的优化级高于WebMvcConfigurer
 * 〉
 * @author luo.yongqian
 * @date 2020/3/14
 * @since 1.0.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorDemo1 interceptorDemo1 = new InterceptorDemo1();
        InterceptorDemo2 interceptorDemo2= new InterceptorDemo2();
        registry.addInterceptor(interceptorDemo1);
        registry.addInterceptor(interceptorDemo2);
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.hasMappingForPattern("/jsp/**");
    }


}