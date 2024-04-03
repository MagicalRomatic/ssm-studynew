package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    //根据姓名和工资查找员工信息
    List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    //更新员工信息(在name,salary都不为空时)
    int update(Employee employee);

    //使用choose，只满足姓名和工资中的一个
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    //批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    //批量更新
    int updateBatch(@Param("list") List<Employee> employees);

    List<Employee> queryAll();
}
