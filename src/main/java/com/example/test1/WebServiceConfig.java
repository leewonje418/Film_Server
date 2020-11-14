package com.example.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServiceConfig implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/comment/**"); // 이 경로로 REQUEST 오면 Interceptor 발동
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) { // CORS 처리라서 냅두세요
        registry.addMapping("/**") //모든 요청에 대해서
                .allowedOrigins("*"); //허용할 오리진들
    }
}
