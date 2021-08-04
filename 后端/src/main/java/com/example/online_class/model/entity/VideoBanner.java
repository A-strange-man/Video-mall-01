package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 轮播图实体类
 */
@Data
@ToString
public class VideoBanner {

    private Integer id;
    // 跳转地址
    private String url;
    // 图片地址
    private String img;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 数字越小越靠前
    private Integer weight;
}
