package com.odamede.springinterceptor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorWebConfig implements WebMvcConfigurer {

/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add LoggingInterceptor and CompressionInterceptor to interceptors registry
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
    }*/
}
