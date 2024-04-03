package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a").between("age",20,30).isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    public void test_02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    public void test_03(){
        //删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void test_04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20).like("name","a").or().isNull("email");

        User user = new User();
        user.setAge(18);
        user.setEmail("user@guigu.com");
        int rows = userMapper.update(user, queryWrapper);
    }

    @Test
    public void test_05(){
        //查询用户信息的name和age字段, id>1
        //SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",1);
        queryWrapper.select("name","age");
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void test_06(){
        //拼接condition判断
        String name = "xx";
        Integer age = 18;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(age != null && age > 18,"age",age);

        userMapper.selectList(queryWrapper);
    }
}
