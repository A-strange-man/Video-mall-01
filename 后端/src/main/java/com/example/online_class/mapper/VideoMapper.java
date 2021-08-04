package com.example.online_class.mapper;

import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    /**
     * 获取所有课程信息
     * @return
     */
    List<Video> getVideoList();

    /**
     * 获取首页轮播图列表
     * @return
     */
    List<VideoBanner> getBannerList();

    /**
     * 获取课程详情-视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询视频详情，不需要章节等信息
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id")int videoId);
}
