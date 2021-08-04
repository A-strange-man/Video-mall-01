package com.example.online_class.controller;

import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;
import com.example.online_class.service.VideoService;
import com.example.online_class.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取所有课程信息-视频列表
     * @return
     */
    @RequestMapping(value = "/list/video", method = RequestMethod.GET)
    public JsonData getVideoList() {
        List<Video> listVideo =  videoService.getVideoList();
        return JsonData.buildSuccess(listVideo);
    }

    /**
     * 获取首页轮播图
     * @return
     */
    @RequestMapping(value = "/list/banner", method = RequestMethod.GET)
    public JsonData indexBanner() {
        List<VideoBanner> listBanner = videoService.getBannerList();
        return JsonData.buildSuccess(listBanner);
    }

    /**
     * 查询视频详情，包含章、集信息
     * @param videoId
     * @return
     */
    @GetMapping("/find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true) int videoId) {
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }
}
