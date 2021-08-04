package com.example.online_class.mapper;

import com.example.online_class.model.entity.Episode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author CaoJing
 * @date 2021/07/26 10:06
 */
@Mapper
public interface EpisodeMapper {

    /**
     * 根据视频 id查找第一集
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
