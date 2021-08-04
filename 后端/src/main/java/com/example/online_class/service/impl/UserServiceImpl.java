package com.example.online_class.service.impl;

import com.example.online_class.model.entity.User;
import com.example.online_class.mapper.UserMapper;
import com.example.online_class.service.UserService;
import com.example.online_class.util.CommonUtils;
import com.example.online_class.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }
    }

    /**
     * 用户登陆，根据手机号和密码查找用户信息
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if (user == null) {
            return null;
        } else {
            String token = JWTUtil.getJsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findById(Integer userId) {
        User user = userMapper.findById(userId);
        return user;
    }

    /**
     * 对象解析，密码需要加密存储
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {

        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setPhone(userInfo.get("phone"));
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            // MD5加密
            String pwd = userInfo.get("pwd");
            user.setPwd(CommonUtils.MD5(pwd));
            return user;

        } else {
            return null;
        }
    }

    /**
     * 随机头像生成
     */
    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int idx = random.nextInt(size);
        return headImg[idx];
    }

    /**
     * 放在cdn上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn- beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn- beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn- beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn- beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn- beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };
}
