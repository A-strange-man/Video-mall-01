package com.example.online_class.service;

import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {

    /**
     * 获取所有课程信息
     * @return
     */
    List<Video> getVideoList();

    /**
     * 获取轮播图列表
     * @return
     */
    List<VideoBanner> getBannerList();

    /**
     * 获取视频课程详情
     * @return
     */
    Video findDetailById(int videoId);
}
