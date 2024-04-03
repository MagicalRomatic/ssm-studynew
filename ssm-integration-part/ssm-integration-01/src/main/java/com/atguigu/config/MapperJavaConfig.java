package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class MapperJavaConfig {
    //SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //设置连接池
        sessionFactoryBean.setDataSource(dataSource);
        //设置配置文件
        ClassPathResource resource = new ClassPathResource("mmybatis-config.xml");
        sessionFactoryBean.setConfigLocation(resource);

        return sessionFactoryBean;

    }
    //mapper代理对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.atguigu.mapper");

        return mapperScannerConfigurer;
    }
}
