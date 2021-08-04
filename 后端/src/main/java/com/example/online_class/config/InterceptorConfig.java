package com.example.online_class.config;

import com.example.online_class.interceptor.CorsInterceptor;
import com.example.online_class.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaoJing
 * @date 2021/07/21 19:47
 *
 * 拦截器配置
 * 不用权限可以访问url   /api/v1/pub
 * 要用权限可以访问url   /api/v1/pri
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor getCorsIntercept0r() {
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(getCorsIntercept0r()).addPathPatterns("/**");

        // 不需要拦截的pri路径
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/api/v1/pri/user/register");
        excludePath.add("/api/v1/pri/user/login");

        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/api/v1/pri/*/*/**")
                .excludePathPatterns(excludePath);
        // 注册拦截器
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
