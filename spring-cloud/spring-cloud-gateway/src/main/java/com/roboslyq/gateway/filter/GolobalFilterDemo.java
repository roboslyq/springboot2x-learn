/**
 * Copyright (C), 2015-2020
 * FileName: GolobalFilterDemo
 * Author:   luo.yongqian
 * Date:     2020/3/18 18:22
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/18 18:22      1.0.0               创建
 */
package com.roboslyq.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/18
 * @since 1.0.0
 */
@Component
public class GolobalFilterDemo implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("全局拦截器,请求路径为: " + exchange.getRequest().getPath());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}