package com.odamede.springinterceptor.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Pre-handle logic (e.g., logging)
        log.info("Log Interceptor: Request received at " , System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        String header = response.getHeader("Response-Message");
        log.info("Log Interceptor response messsage postHandle: " , header);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper(response);
        byte[] responseBody = resp.getContentAsByteArray();
        String res = new String(responseBody, StandardCharsets.UTF_8);
        log.info("Log Interceptor response ContentCachingResponse : ",res);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        String header = response.getHeader("Response-Message");
        log.info("Log Interceptor response messsage after Completion: " , header);
        ContentCachingResponseWrapper resp = new ContentCachingResponseWrapper(response);
        byte[] responseBody = resp.getContentAsByteArray();
        String res = new String(responseBody, StandardCharsets.UTF_8);
        log.info("Log Interceptor response ContentCachingResponse aftrerComp : ",res);
    }
}