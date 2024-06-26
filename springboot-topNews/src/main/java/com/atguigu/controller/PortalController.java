package com.atguigu.controller;

import com.atguigu.service.TypeService;
import com.atguigu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {
    @Autowired
    private TypeService typeService;

    @GetMapping("findAllTypes")
    public Result findAllTypes(){
        Result result = typeService.findAllTypes();
        return result;
    }
}
