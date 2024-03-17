package com.test.api.config;

import com.test.api.interceptor.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @create: 2024-03-17 23:53
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RequestTimeInterceptor requestTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeInterceptor).addPathPatterns("/**");
    }
}
