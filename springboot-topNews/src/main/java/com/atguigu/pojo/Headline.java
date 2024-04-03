package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class Headline {
    @TableId
    private Integer hid;
    private String article;
    private Date createTime;
    private Integer isDeleted;
    private Integer pageViews;
    private Integer publisher;
    private String title;
    private Integer type;
    private Date updateTime;
    @Version
    private Integer version;
}
