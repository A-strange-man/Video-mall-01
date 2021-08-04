package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 用户-实体类
 */
@Data
@ToString
public class User {

    private Integer id;
    // 昵称
    private String name;
    // 密码
    @JsonIgnore
    private String pwd;
    // 头像
    @JsonProperty("head_img")
    private String headImg;
    // 手机号
    private String phone;
    // 创建时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
