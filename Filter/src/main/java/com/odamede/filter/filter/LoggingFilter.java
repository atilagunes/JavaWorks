package com.odamede.filter.filter;


import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ResponseFacade;

import java.io.IOException;

@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Logging Filter: Request received at " , System.currentTimeMillis());
        log.info("Request Scheme: " , request.getScheme());
        log.info("Request parameter id: " , request.getParameter("id"));
        log.info("Request : " , request.getReader().readLine());
        if(response!=null) {
            ResponseFacade response1 = (ResponseFacade) response;
            String originalResponseMessage = response1.getHeader("Response-Message");
            log.info("doFilter response Message ",originalResponseMessage);

            // Modify the response message or add a new header
            if(originalResponseMessage!=null) {
                String modifiedResponseMessage = originalResponseMessage.replace("sigortaNo", "sigortaNumarasi");
                response1.setHeader("Response-Message", modifiedResponseMessage);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
