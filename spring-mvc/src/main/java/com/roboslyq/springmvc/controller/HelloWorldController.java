package com.roboslyq.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author roboslyq
 * @data 2019/1/2 23:22
        * @desc :
        **/
@RestController
public class HelloWorldController {
    @RequestMapping("")
    public String index() {
        System.out.println("hello");
        String a = "bb";
        return "index";
    }
}
