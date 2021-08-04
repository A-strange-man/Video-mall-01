package com.example.online_class.util;

import com.example.online_class.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类
 */
public class JWTUtil {

    // 过期时间 : 一周
    private static final long EXPIRE = 60000 * 60 * 24 * 7;

    // 加密密钥
    private static final String SECRET = "class.net159";

    // 令牌前缀
    private static final String TOKEN_PREFIX = "class";

    // subject
    private static final String SUBJECT = "class";

    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String getJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("head_img", user.getHeadImg())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
