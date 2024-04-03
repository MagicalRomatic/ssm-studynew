package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Type {
    @TableId
    private Integer tid;

    private Integer isDeleted;
    private String tname;

    @Version
    private Integer version;
}
