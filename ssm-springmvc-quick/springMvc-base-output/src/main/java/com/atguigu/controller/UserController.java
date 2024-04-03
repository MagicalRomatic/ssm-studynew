package com.atguigu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("data")
    //空指针异常
    public String data(){
        String name = null;
        return name.toString();
    }

    @GetMapping("data1")
    public String data1(){
        int i = 1/0;
        return "ok";
    }
}
