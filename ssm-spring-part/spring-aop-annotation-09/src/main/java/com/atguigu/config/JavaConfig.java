package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.atguigu")
@EnableAspectJAutoProxy //支持切面的动态代理
public class JavaConfig {

}
