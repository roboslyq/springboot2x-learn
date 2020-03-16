/**
 * Copyright (C), 2015-2020
 * FileName: WebConfig2
 * Author:   luo.yongqian
 * Date:     2020/3/14 17:34
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/14 17:34      1.0.0               创建
 */
package com.roboslyq.springmvc.config;

import com.roboslyq.springmvc.interceptor.InterceptorDemo1;
import com.roboslyq.springmvc.interceptor.InterceptorDemo2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 〈优先级低于 WebMvcConfigurationSupport ，如果两个配置同时存在，WebMvcConfigurationSupport中的配置生效。
 * 当前类的配置不生效〉
 * @author luo.yongqian
 * @date 2020/3/14
 * @since 1.0.0
 */
@Configuration
//public class WebConfig2 extends WebMvcConfigurerAdapter {

public class WebConfig2 implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorDemo2());
    }
}