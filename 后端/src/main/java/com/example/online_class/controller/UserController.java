package com.example.online_class.controller;

import com.example.online_class.model.entity.User;
import com.example.online_class.model.request.LoginRequest;
import com.example.online_class.service.UserService;
import com.example.online_class.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册，只接受json格式数据
     * 一个手机号只能注册一次，在数据库对该字段建立了unique索引
     * @param userInfo
     * @return
     */
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonData register(@RequestBody Map<String, String> userInfo) {

        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败-请重试");
    }

    /**
     * 用户登陆，需要有 手机号 和 密码
     * @param loginRequest
     * @return
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public  JsonData login(@RequestBody LoginRequest loginRequest) {

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("登陆失败，账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 用户查询信息 - 需要登陆状态有效
     * 拦截器拦截 -> 拦截器根据token解密获得用户ID -> 根据用户ID查询到用户信息(密码信息不会返回到前端)
     * @param request
     * @return
     */
    @GetMapping(value = "/find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }
        User user = userService.findById(userId);
        return JsonData.buildSuccess(user);
    }

}
