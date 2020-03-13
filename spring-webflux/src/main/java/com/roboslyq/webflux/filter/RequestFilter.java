/**
 * Copyright (C), 2015-2019
 * FileName: RequestFilter
 * Author:   luo.yongqian
 * Date:     2019/5/7 18:31
 * Description: 请求拦截器
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2019/5/7 18:31      1.0.0               创建
 */
package com.roboslyq.webflux.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 *
 * 〈请求拦截器〉：webflux可以复用servlet的相关拦截器实现。
 *
 * @author luo.yongqian
 * @create 2019/5/7
 * @since 1.0.0
 */
@Configuration
@Order(-1)
public class RequestFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        System.out.println("[com.roboslyq.webflux.filter.RequestFilter :] start servlet filter... ...");
        ServerHttpRequest request =  serverWebExchange.getRequest();

        //获取请求http头xttblog_token值
        String token = request.getHeaders().getFirst("token_user_id");
        System.out.println("token_user_id ＝" + token);

        //添加请求属性key和value
        serverWebExchange.getAttributes().put("url", "https://roboslyq.github.io/");

        /*
        * 过滤器链的概念都是类似的，调用过滤器链的filter方法将请求转到下一个filter，如果该filter是最后一个filter,那就转到
        * 该请求对应的handler,也就是controller方法或函数式endpoint
        */
        Mono<Void> result =  webFilterChain.filter(serverWebExchange);

        System.out.println("[com.roboslyq.webflux.filter.RequestFilter :] end filter... ...");

        return result;
    }
}