package com.atguigu.test;

import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_05.JavaBean;
import com.atguigu.ioc_05.JavaBeanFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    /**
     * 如何创建IoC容器并读取配置文件
     */
    public void createIoC(){
        //构造函数(String...配置文件)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc03.xml");

    }

    /**
     * 在IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoC(){
        //创建一个IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc03.xml");
        //获取组件
        //单例模式下返回的都是同一个组件，默认
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        HappyComponent bean = applicationContext.getBean(HappyComponent.class);
        bean.doWork();
    }

    /**
     * 测试ioc配置和销毁过程
     */
    @Test
    public void test_04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc04.xml");
        applicationContext.close();
    }

    /**
     * 测试标准工厂的实现
     * @throws Exception
     */
    @Test
    public void test_05() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc05.xml");
        /*JavaBeanFactoryBean bean = applicationContext.getBean(JavaBeanFactoryBean.class);
        JavaBean javaBean = bean.getObject();
        System.out.println(javaBean.toString());*/
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean.toString());
    }
}
