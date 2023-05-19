package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//2. Controller 대신 RestController를 사용하면 ResponseBody 어노테이션을 사용하지 않아도 된다.
//@Controller
public class HelloController {
    @GetMapping("/hello")

    public String hello() {
        return "Hello world";
    }
//    public @ResponseBody String hello() {
//        //1. @ResponseBody를 선언하면 return 하는 문자열을 그대로 리턴한다. view가 아니라!
//        return "Hello World";
//    }
}
