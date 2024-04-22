package com.atguigu.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//增强类
@Component
@Aspect
public class LogAdvice {

    //前置
    @Before("com.atguigu.pointCut.MyPointCut.myPc()")
    public void start(){
        System.out.println("方法开始执行");
    }

    //后置
    @After("com.atguigu.pointCut.MyPointCut.myPc()")
    public void after(){
        System.out.println("方法结束执行");
    }

    //异常
    @AfterThrowing("com.atguigu.pointCut.MyPointCut.myPc()")
    public void error(){
        System.out.println("方法出错");
    }
}
