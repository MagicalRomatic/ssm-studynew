package com.atguigu.ioc;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springIocTest {

    @Test
    public void test(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring01.xml");

        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.findAll();
    }
}
