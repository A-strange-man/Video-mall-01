package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 章节信息-实体类
 */
@Data
@ToString
public class Chapter {

    private Integer id;
    // 视频主键
    @JsonProperty("video_id")
    private Integer videoId;
    // 章节名称
    private String title;
    // 章节顺序
    private Integer ordered;
    // 创建时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 集信息
    @JsonProperty("episode_list")
    private List<Episode> episodeList;
}
