package com.atguigu.service;

import com.atguigu.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生信息的接口
     * @return
     */
    List<Student> findAll();
}
