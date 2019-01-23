package com.roboslyq.thymeleaf.web.advice;

import com.roboslyq.thymeleaf.web.controller.HelloworldController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

@ControllerAdvice( assignableTypes = HelloworldController.class)
public class HelloWorldControllerAdvice {
    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return  acceptLanguage;
    }
    @ModelAttribute("jessessionId")
    public String jessessionId(@RequestHeader(value = "JSESSIONID",required = false) String jessessionId){
        return  jessessionId;
    }
    @ModelAttribute("message")
    public String message(){
        return  "hellow world";
    }
@ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return  ResponseEntity.ok(throwable.getMessage());
}
}
