/**
 * Copyright (C), 2015-2020
 * FileName: WebFluxController
 * Author:   luo.yongqian
 * Date:     2020/3/12 19:39
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2020/3/12 19:39      1.0.0               创建
 */
package com.roboslyq.webflux.controller;

import com.roboslyq.webflux.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.File;

//import org.springframework.web.reactive.function.server.ServerRequest;

/**
 *
 * 〈WebFlux控制器，返回的是Mono/Flux〉
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/webflux")
public class WebFluxController {

    @GetMapping("/")
    public Mono<String> welcome(ServerWebExchange serverWebExchange
                        , ServerHttpRequest serverHttpRequest
                        ,@RequestAttribute String url) {
        /*
         * 获取在Filter中添加的属性，与@RequestAttribute 效果一样。
         */
        String url1 = serverWebExchange.getAttribute("url");
        /*
         * "web flux 异步测试"先于"Hello,Webflux"打印，因为响应式具有惰性/延迟执行
         */
        Mono<String> result = Mono.just("Hello,Webflux").doOnNext(System.out::println);
        System.out.println("web flux 异步测试" + url1 );
        return result;
    }

    /**
     * 测试对象接收参数和同步
     * @param serverWebExchange  请求serverHttpRequest和serverHttpResponse的包装
     * @param serverHttpRequest
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User createUser(ServerWebExchange serverWebExchange
                            , ServerHttpRequest serverHttpRequest
                            , @RequestBody User user
                            , @RequestAttribute String url) {
        System.out.println(user.getId());
        System.out.println(url);
        return user;
    }


    @GetMapping("/download")
    public Mono<Void> download(ServerWebExchange serverWebExchange
            , ServerHttpRequest request
            , ServerHttpResponse response) {
        File file = new File("D:\\ShutdownHook.java");
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=shutdown.java");
        response.getHeaders().setContentType(MediaType.IMAGE_PNG);
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }
}