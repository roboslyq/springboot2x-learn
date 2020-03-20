/**
 * Copyright (C), 2015-2020
 * FileName: GatewayFilterDemo
 * Author:   luo.yongqian
 * Date:     2020/3/18 18:27
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/18 18:27      1.0.0               创建
 */
package com.roboslyq.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
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
public class GatewayFilterDemo implements GatewayFilter,Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("局部拦截器，获取请求路径：" + exchange.getRequest().getPath());
        return chain.filter(exchange).then(  Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            System.out.println("后置拦截器,响应状态： " + response.getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}