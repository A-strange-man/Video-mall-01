package com.example.online_class.mapper;

import com.example.online_class.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CaoJing
 * @date 2021/07/26 10:43
 */
@Mapper
public interface PlayRecordMapper {

    /**
     * 添加视频播放记录
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);
}
