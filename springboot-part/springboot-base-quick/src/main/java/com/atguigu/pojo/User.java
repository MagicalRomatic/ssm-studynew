package com.atguigu.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 倒入配置文件的数据
 */
@Data
@Component
@ConfigurationProperties(prefix = "zwf.user")
public class User {
    //key与属性名相同即可
    private String username;
    private String password;
    private List<String> gfs;
}
