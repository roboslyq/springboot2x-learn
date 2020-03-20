/**
 * Copyright (C), 2015-2020
 * FileName: FilterBeanCofniguration
 * Author:   luo.yongqian
 * Date:     2020/3/18 18:33
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/18 18:33      1.0.0               创建
 */
package com.roboslyq.gateway.config;

import com.roboslyq.gateway.filter.GatewayFilterDemo;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈使用Bean方式配置Router,可以与配置文件共存〉
 *
 * @author luo.yongqian
 * @date 2020/3/18
 * @since 1.0.0
 */
@Configuration
public class FilterBeanCofniguration {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/b")
                                .filters(f -> f.filter(new GatewayFilterDemo())
                                        //.addResponseHeader("X-Response-Default-Foo", "Default-Bar")
                                                )
                                .uri("https://howtodoinjava.com/")
                                .order(0)
                                .id("baidu_filter")
                        )
                .route(r -> r.path("/spring")
                        .filters(f -> f.filter(new GatewayFilterDemo())
                        )
                        .uri("https://howtodoinjava.com/")
                        .order(0)
                        .id("spring_filter"))
                .build();
    }

}