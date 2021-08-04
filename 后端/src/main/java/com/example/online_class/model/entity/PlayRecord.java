package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author CaoJing
 * @date 2021/07/26 9:59
 *
 * 播放记录表 - 实体类
 */
@Data
public class PlayRecord {
    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("video_id")
    private int videoId;
    // 当前播放第几集
    @JsonProperty("current_num")
    private int currentNum;
    // 当前播放第几集视频id
    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
