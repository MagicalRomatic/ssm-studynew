package com.atguigu.ioc_04;

public class JavaBean {
    //bean的生命周期方法
    public void init(){
        System.out.println("JavaBean.init");
    }

    public void destroy(){
        System.out.println("JavaBean.destroy");
    }
}
