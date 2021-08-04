package com.example.online_class.service.impl;

import com.example.online_class.exception.CustomException;
import com.example.online_class.mapper.*;
import com.example.online_class.model.entity.Episode;
import com.example.online_class.model.entity.PlayRecord;
import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoOrder;
import com.example.online_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CaoJing
 * @date 2021/07/22 18:09
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 下单操作
     * 下单 和 生成播放记录 要么都成功，要么都失败
     * 需要开启事务
     *
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional  // 默认隔离级别是 READ_COMMITTED
    public int save(int userId, int videoId) {
        // 判断用户是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }

        Video video = videoMapper.findById(videoId);
        VideoOrder newOrder = new VideoOrder();
        newOrder.setCreateTime(new Date());
        newOrder.setOutTradeNo(UUID.randomUUID().toString());
        newOrder.setState(1);
        newOrder.setTotalFee(video.getPrice());
        newOrder.setUserId(userId);
        newOrder.setVideoId(videoId);
        newOrder.setVideoImg(video.getCoverImg());
        newOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newOrder);
        // 用户下单成功之后生成播放记录
        if (rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if (episode == null) {
               throw new CustomException(-1, "视频没有集信息，请运营检测");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setVideoId(videoId);
            playRecord.setUserId(userId);
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setEpisodeId(episode.getId());
            // 更新播放记录
            playRecordMapper.saveRecord(playRecord);
        }

        return rows;
    }

    /**
     * 获取订单列表
     * @param userId
     * @return
     */
    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {

        return videoOrderMapper.listOrderByUserId(userId);
    }
}
