package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置web容器，controller，springmvc
 */
@Configuration
@ComponentScan({"com.atguigu.controller","com.atguigu.exception"})
@EnableWebMvc
public class WebJavaConfig implements WebMvcConfigurer {
    //静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
