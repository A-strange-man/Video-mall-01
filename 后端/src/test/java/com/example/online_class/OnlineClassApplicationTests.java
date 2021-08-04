package com.example.online_class;

import com.example.online_class.model.entity.User;
import com.example.online_class.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineClassApplicationTests {

    // 日志工具
    private static final Logger log = LoggerFactory.getLogger(OnlineClassApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void testJWT() {
        User user = new User();
        user.setId(666);
        user.setHeadImg("png");
        user.setName("class");

        String token = JWTUtil.getJsonWebToken(user);
        log.info("token = {}", token);

        Claims claims = JWTUtil.checkJWT(token);
        log.info("name = {}", claims.get("name"));
    }

}
