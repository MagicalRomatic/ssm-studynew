package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void test_page(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);

        //将查询到的结果封装到page中
        List<User> records = page.getRecords();
        System.out.println("records = " + records);

        long current = page.getCurrent();
        long size = page.getSize();
        long total = page.getTotal();

    }

}
