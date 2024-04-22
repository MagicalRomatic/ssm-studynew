package com.atguigu.test;

import com.atguigu.config.JavaConfigurator;
import com.atguigu.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {
    @Test
    public void test(){
        //创建IOC容器，使用配置类的形式
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfigurator.class);

        StudentController controller = applicationContext.getBean(StudentController.class);
        System.out.println("controller = " + controller);
    }
}
