package com.atguigu.pointCut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 存放切点的信息
 * 切点表达式，进行维护
 */
@Component
public class MyPointCut {

    @Pointcut("execution(* com..impl.*.*(..))")
    public void pc(){}

    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void myPc(){}
}
