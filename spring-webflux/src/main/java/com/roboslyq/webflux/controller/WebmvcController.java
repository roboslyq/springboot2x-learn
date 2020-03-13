package com.roboslyq.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *  传统的WebMvc控制器，返回的是普通对象。
 *  @author luo.yongqian
 *
 */
@RestController
public class WebmvcController {
    @PostMapping(path = "/"
                , consumes = { MediaType.APPLICATION_JSON_VALUE
                                , "!application/xml" }
                , produces = MediaType.TEXT_PLAIN_VALUE
                //限制条件：请求头中必须的X-Custom，并且值为Foo
                , headers = "X-Custom=Foo"
                , params = "a!=alpha")
    public String example() {
        return "Hello World Post";
    }


    @GetMapping("/")
    public String welcome() {
        return "Hello World Get";
    }

}