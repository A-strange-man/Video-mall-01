package com.example.online_class.mapper;

import com.example.online_class.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    User findByPhone(@Param("user_phone") String phone);

    /**
     * 存储用户信息
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 用户登陆校验
     * @param phone
     * @param pwd
     * @return
     */
    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据ID查询用户信息
     * @param userId
     * @return
     */
    User findById(@Param("user_id") Integer userId);
}
