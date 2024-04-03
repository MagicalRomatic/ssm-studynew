package com.atguigu.json;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("json")
public class JsonController {
    //向前端返回JSON字符串
    @RequestMapping("data")
    @ResponseBody
    public User data(){
        User user = new User();
        user.setName("two Dogs");
        user.setAge(3);

        return user;
    }


}
