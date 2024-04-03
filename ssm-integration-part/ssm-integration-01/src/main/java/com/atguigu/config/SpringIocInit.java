package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //root Ioc容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfigNew.class, ServiceJavaConfig.class};
    }

    //web Ioc容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebJavaConfig.class};
    }

    //servlet拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
