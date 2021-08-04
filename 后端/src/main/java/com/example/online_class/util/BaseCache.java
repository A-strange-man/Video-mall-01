package com.example.online_class.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author CaoJing
 * @date 2021/07/27 8:46
 *
 * 缓存工具类
 */
@Component
public class BaseCache {

    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            .initialCapacity(10)    // 设置缓存初始大小
            .maximumSize(100)       // 最大值
            .concurrencyLevel(4)    // 并发数设置
            .expireAfterWrite(10, TimeUnit.SECONDS)    // 写入10秒后过期
            .recordStats()          // 统计缓存命中率
            .build();

    private Cache<String, Object> oneHourCache = CacheBuilder.newBuilder()
            .initialCapacity(10)    // 设置缓存初始大小
            .maximumSize(100)       // 最大值
            .concurrencyLevel(4)    // 并发数设置
            .expireAfterWrite(1, TimeUnit.HOURS)    // 写入1小时后过期
            .recordStats()          // 统计缓存命中率
            .build();

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}
