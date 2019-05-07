/**
 * Copyright (C), 2015-2019
 * FileName: WebExceptionHandlerDemo
 * Author:   luo.yongqian
 * Date:     2019/5/7 18:44
 * Description: webflux统一异常处理
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2019/5/7 18:44      1.0.0               创建
 */
package com.roboslyq.webflux.exception;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 要比DefaultErrorWebExceptionHandler优先级-1高
 * 比较底层，如果异常被@ExceptionHandler处理了，那么将不会由此处理
 * 可以处理filter和webHandler中的异常
 * 〈webflux统一异常处理〉
 * @author luo.yongqian
 * @create 2019/5/7
 * @since 1.0.0
 */
public class WebExceptionHandlerDemo implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = ("ErrorLogHandler: " + ex.getMessage()).getBytes(StandardCharsets.UTF_8);
        DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Flux.just(wrap));
    }

    @ExceptionHandler(Exception.class)
    public String test(Exception e) {
        return "@WebExceptionHandlerDemo: " + e.getMessage();
    }
}