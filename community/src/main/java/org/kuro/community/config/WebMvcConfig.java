package org.kuro.community.config;

import org.kuro.community.interceptor.LoginRequiredInterceptor;
import org.kuro.community.interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 白鸟亦悲否？
 * @Date: 2021/1/30 10:00
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("*.css", "*.js", "*.png", "*.jpg", "*.jpeg");

        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("*.css", "*.js", "*.png", "*.jpg", "*.jpeg");
    }
}
