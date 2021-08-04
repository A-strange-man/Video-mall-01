package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 视频信息-实体类
 */
@Data
@ToString
public class Episode {

    private Integer id;
    // 集标题
    private String title;
    // 第几集，全局顺序
    private Integer num;
    // 章里面的顺序
    private Integer ordered;
    // 播放地址
    @JsonProperty("play_url")
    private String playUrl;
    // 章主键id
    @JsonProperty("chapter_id")
    private Integer chapterId;
    // 是否免费 0-免费，1-付费
    private Integer free;
    // 视频id
    @JsonProperty("video_id")
    private Integer videoId;
    // 创建时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
