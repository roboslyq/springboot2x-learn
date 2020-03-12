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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * 〈〉
 * @author luo.yongqian
 * @date 2020/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/webflux")
public class WebFluxController {
    @GetMapping("/")
    public Mono<String> welcome() {
        Mono<String> result = Mono.just("Hello,Webflux").doOnNext(System.out::println);
        System.out.println("web flux 异步测试");
        return result;
    }


}