package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Before("com.atguigu.pointCut.MyPointCut.pc()")
    public void before(JoinPoint joinPoint){
        //JoinPoint获取目标类的相关信息
        //目标类的类名称
        String ClassName = joinPoint.getTarget().getClass().getName();
        //目标类的方法名
        String name = joinPoint.getSignature().getName();
        //获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    @AfterReturning(value = "com.atguigu.pointCut.MyPointCut.pc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        //result 返回的结果
    }

    @After("com.atguigu.pointCut.MyPointCut.pc()")
    public void after(){

    }

    @AfterThrowing(value = "com.atguigu.pointCut.MyPointCut.pc()", throwing = "throwing" )
    public void afterThrowing(JoinPoint joinPoint, Throwable throwing){

    }
}
