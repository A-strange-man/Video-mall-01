package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 课程-实体类
 */
@Data
@ToString
public class Video {

    private Integer id;
    // 视频标题
    private String title;
    // 概述
    private String summary;
    // 封面图
    @JsonProperty("cover_img")
    private String coverImg;
    // 价格(分)
    private Integer price;
    // 创建时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 评分
    private Double point;
    // 章列表
    @JsonProperty("chapter_list")
    private List<Chapter> chapterList;
}
