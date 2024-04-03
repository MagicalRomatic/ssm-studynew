package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.util.JwtHelper;
import com.atguigu.util.MD5Util;
import com.atguigu.util.Result;
import com.atguigu.util.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 1.到后端查找用户数据
     * 2.未找到用户，报错
     * 3.找到用户，校验密码，密码错误，报错
     * 4.密码正确，将token封装，返回到前端
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if(!StringUtils.isEmpty(loginUser.getUserPwd()) && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));

            Map<String,String> data = new HashMap<>();
            data.put("token",token);

            return Result.ok(data);
        }

        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    /**
     * 1.查验token是否过期
     * 2.根据id找到用户信息，未找到即为未登录
     * 3.密码制空返回信息
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        if (jwtHelper.isExpiration(token)){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }

        int id = jwtHelper.getUserId(token).intValue();
        User loginUser = userMapper.selectById(id);
        loginUser.setUserPwd("");

        Map<String,User> data = new HashMap<>();
        data.put("loginUser",loginUser);

        return Result.ok(data);
    }

    /**
     * 根据用户名查找用户信息，检查账号是否被占用
     * @param username
     * @return
     */
    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        Long count = userMapper.selectCount(queryWrapper);

        if(count == 0){
            return Result.ok(null);
        }

        return Result.build(null,ResultCodeEnum.USERNAME_USED);
    }

    /**
     * 用户注册
     * 1.检验用户名是否被注册
     * 2.密码加密
     * 3.插入数据库
     * @param user
     * @return
     */
    @Override
    public Result regist(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        Long count = userMapper.selectCount(queryWrapper);

        if(count > 0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);

        return Result.ok(null);
    }
}
