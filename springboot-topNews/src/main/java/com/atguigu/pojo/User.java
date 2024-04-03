package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class User {
    @TableId
    private Integer uid;

    private Integer isDeleted;
    private String nickName;
    private String userPwd;
    private String username;
    @Version
    private Integer version;
}
