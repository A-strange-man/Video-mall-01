package com.example.online_class.service;

import com.example.online_class.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    /**
     * 用户登陆，根据手机号和密码查找用户信息
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);

    /**
     * 根据ID查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);
}
