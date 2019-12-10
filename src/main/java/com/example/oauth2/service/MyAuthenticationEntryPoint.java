package com.example.oauth2.service;

import com.alibaba.fastjson.JSONObject;
import com.example.oauth2.model.CodeMessage;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Performs the redirect (or forward) to the login form URL.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // redirect to login page. Use https if forceHttps true

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(CodeMessage.NoLogin));// 返回 JSON 信息
        response.flushBuffer();
    }
}
