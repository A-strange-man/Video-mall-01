package com.example.online_class.service;

import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoOrder;

import java.util.List;

/**
 * @author CaoJing
 * @date 2021/07/22 18:08
 */
public interface VideoOrderService {

    /**
     * 下单
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);

    /**
     * 获取订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(Integer userId);
}
