package com.example.online_class.interceptor;

import com.example.online_class.util.JWTUtil;
import com.example.online_class.util.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author CaoJing
 * @date 2021/07/21 19:09
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }

            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JWTUtil.checkJWT(accessToken);
                if (claims == null) {
                    // 告知前端登陆过期，重新登陆
                    sendJsonData(response, JsonData.buildError("登陆过期，请重新登陆"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                request.setAttribute("user_id", id);
                request.setAttribute("user_name", name);
                return true;
            }

        } catch (Exception e) {}

        // 登陆失败
        sendJsonData(response, JsonData.buildError("登陆失败，请重新登陆"));
        return false;
    }

    /**
     * 响应json数据给前端
     * @param response
     * @param obj
     */
    public static void sendJsonData(HttpServletResponse response, Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            response.flushBuffer();

        } catch (Exception e) {}
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
