package com.roboslyq.thymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloworldController {
    @RequestMapping("")
    public String index(@RequestParam(name = "value",required = false) String value) {
        System.out.println("hello");
        String a = "bb";
        return "index";
    }
    @GetMapping(path = "hello-world")
    public String helloWorld(){
        return  "hello-world";
    }

    @ModelAttribute(name = "message")
    private String message(){
        return "HelloWorld，roboslyq1";
    }
}
