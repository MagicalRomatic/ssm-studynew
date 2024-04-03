package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusUpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    //使用QueryWrapper修改值
    @Test
    public void test_04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20).like("name","a").or().isNull("email");

        //不能处理空值
        User user = new User();
        user.setAge(18);
        user.setEmail("user@guigu.com");
        int rows = userMapper.update(user, queryWrapper);
    }

    //使用UpdateWrapper修改值
    @Test
    public void test_01(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email")
                .set("age",18)
                .set("email","user@guigu.com");

        userMapper.update(null,updateWrapper);
    }
}
