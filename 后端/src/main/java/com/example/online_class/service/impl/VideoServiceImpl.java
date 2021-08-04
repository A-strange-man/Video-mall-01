package com.example.online_class.service.impl;

import com.example.online_class.config.CacheKeyManager;
import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;
import com.example.online_class.mapper.VideoMapper;
import com.example.online_class.service.VideoService;
import com.example.online_class.util.BaseCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private static final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    /**
     * 获取视频列表
     * @return
     */
    @Override
    public List<Video> getVideoList() {
        // 使用guava缓存
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, ()->{
                return videoMapper.getVideoList();
            });

            if (cacheObj instanceof List) {
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }

        } catch (Exception e) {
            log.error("获取视频列表-发生异常-{}", e.getMessage());
        }

        return null;
    }

    /**
     * 获取轮播图
     * @return
     */
    @Override
    public List<VideoBanner> getBannerList() {
        // 使用guava缓存
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                return videoMapper.getBannerList();
            });

            if (cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (Exception e) {
            log.error("获取轮播图-发生异常-{}", e.getMessage());
        }

        return null;
    }

    /**
     * 视频详情
     * @param videoId
     * @return
     */
    @Override
    public Video findDetailById(int videoId) {
        String videoCacheKey= String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
        try {
            Object cacheObj = baseCache.getOneHourCache().get(videoCacheKey, ()->{
                return videoMapper.findDetailById(videoId);
            });

            if (cacheObj instanceof Video) {
                Video video = (Video) cacheObj;
                return video;
            }

        } catch (Exception e) {
            log.error("获取视频详情-发生异常-{}", e.getMessage());
        }

        return null;
    }
}
