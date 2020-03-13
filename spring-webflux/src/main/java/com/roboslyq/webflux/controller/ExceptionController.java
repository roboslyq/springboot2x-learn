/**
 * Copyright (C), 2015-2020
 * FileName: ExceptionController
 * Author:   luo.yongqian
 * Date:     2020/3/13 17:24
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/13 17:24      1.0.0               创建
 */
package com.roboslyq.webflux.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Null;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/1")
    public Mono<String> exception1(ServerWebExchange serverWebExchange
            , ServerHttpRequest serverHttpRequest
            , @RequestAttribute String url) {

        return Mono.just(mockException());
    }

    @GetMapping("/2")
    public Mono<String> exception2(ServerWebExchange serverWebExchange
            , ServerHttpRequest serverHttpRequest
            , @RequestAttribute String url) {

        return Mono.just(mockException());
    }




    public String mockException(){
        return null;
    }

}