package com.atguigu.controller;

import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentControllerImpl implements StudentController{
    @Autowired
    private StudentService studentService;

    @Override
    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println("students = " + students);
    }
}
