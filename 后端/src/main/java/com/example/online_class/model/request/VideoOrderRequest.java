package com.example.online_class.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author CaoJing
 * @date 2021/07/22 18:01
 */
@Data
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int VideoId;
}
