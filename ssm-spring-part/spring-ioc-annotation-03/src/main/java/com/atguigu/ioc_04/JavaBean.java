package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    //用注解的方式从配置文件中取出变量值
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
}
