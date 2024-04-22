package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void testIoC_01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring01.xml");

        XxxDao bean = applicationContext.getBean(XxxDao.class);

        System.out.println("bean= " + bean);

        //用注解取出bean 默认的组件名为类名首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);
    }
}
