package com.roboslyq.thymeleaf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HelloworldController {

    @GetMapping(path = "hello-world")
    public String helloWorld(){
        return  "hello-world";
    }

    @ModelAttribute(name = "message")
    private String message(){
        return "HelloWorld，roboslyq1";
    }
}
