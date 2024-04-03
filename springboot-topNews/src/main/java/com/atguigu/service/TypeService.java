package com.atguigu.service;

import com.atguigu.pojo.Type;
import com.atguigu.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TypeService extends IService<Type> {
    /**
     * 查询所有分类
     * @return
     */
    Result findAllTypes();
}
