package com.yuqijun.localservice.socket.filter;

import org.apache.tomcat.websocket.server.UpgradeUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LsWsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if(UpgradeUtil.isWebSocketUpgradeRequest(request,response)){
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;

        }
    }
}
