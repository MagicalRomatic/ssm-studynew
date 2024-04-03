package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    /**
     * 登录业务
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据请求头中的token获取用户信息
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 检查用户名是否被占用
     * @param username
     * @return
     */
    Result checkUserName(String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Result regist(User user);
}
