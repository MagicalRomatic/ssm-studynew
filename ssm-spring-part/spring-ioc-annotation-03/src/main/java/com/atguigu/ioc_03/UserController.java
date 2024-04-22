package com.atguigu.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //自动装配
    @Autowired
    private UserService userService;

    public void show(){
        userService.show();
    }
}
