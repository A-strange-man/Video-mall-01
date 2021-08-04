package com.example.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 视频订单-实体类
 */
@Data
@ToString
public class VideoOrder {

    private Integer id;
    // 唯一订单标识
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    // 支付状态: 0-未支付， 1-已支付
    private Integer state;
    // 订单生成时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    // 支付金额（分）
    @JsonProperty("total_fee")
    private Integer totalFee;
    // 视频主键
    @JsonProperty("video_id")
    private Integer videoId;
    // 视频标题
    @JsonProperty("video_title")
    private String videoTitle;
    // 视频图片
    @JsonProperty("video_img")
    private String videoImg;
    // 用户id
    @JsonProperty("user_id")
    private Integer userId;
}
