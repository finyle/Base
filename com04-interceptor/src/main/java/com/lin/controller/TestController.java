package com.lin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        System.out.println("控制器中的方法执行了");
        return "hello";
    }
}
