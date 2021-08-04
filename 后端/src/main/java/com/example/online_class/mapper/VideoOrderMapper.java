package com.example.online_class.mapper;

import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CaoJing
 * @date 2021/07/22 18:12
 */
@Mapper
public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此产品
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId
                                            , @Param("video_id") int videoId
                                            , @Param("state") int state);

    /**
     * 下单(此前没有购买过此视频)
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 获取订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
