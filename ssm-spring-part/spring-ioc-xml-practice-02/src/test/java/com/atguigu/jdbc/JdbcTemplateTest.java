package com.atguigu.jdbc;

import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    /**
     * jdbc在IoC容器中的应用
     */
    @Test
    public void jdbcForIoC(){
        //获得IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring01.xml");

        //得到Jdbc对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        //对数据库进行CRUD操作
        //增加一条学生信息
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,9,"二狗子","男",18,"三年二班");

        //根据id值查询学生信息
        sql = "select * from students where id = ?";
        //查询单个对象
        Student student = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Student stu = new Student();
                //rs时结果集
                //自己处理结果映射
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setGender(rs.getString("gender"));
                stu.setAge(rs.getInt("age"));
                stu.setClasses(rs.getString("class"));

                return stu;
            }, 1);

        System.out.println(student.toString());

        //查询student的集合
        sql = "select id,name,gender,age,class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

    }

    /**
     * 使用Ioc容器实现了查询学生信息的三层架构
     */
    @Test
    public void testFindAll(){
        //创建IoC容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring02.xml");

        //获取组件
        StudentController controller = applicationContext.getBean(StudentController.class);
        //使用组件
        controller.findAll();
        //关闭容器
        applicationContext.close();
    }
}
