/**
 * Copyright (C), 2015-2020
 * FileName: UserCheckFilter
 * Author:   luo.yongqian
 * Date:     2020/3/13 18:21
 * Description: 用户信息检查
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/13 18:21      1.0.0               创建
 */
package com.roboslyq.webflux.filter;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 *
 * 〈用户信息检查〉
 * @author luo.yongqian
 * @date 2020/3/13
 * @since 1.0.0
 */
public class UserCheckFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return null;
    }
}