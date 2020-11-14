package com.example.test1;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {
        HttpSession httpSession = request.getSession(); // 여기가 문제, 여기서 null뜨면 안됨
        if (httpSession.getAttribute("sessionId") != null) {
            response.getOutputStream().print("YAY");
            return true;
        }
        response.getOutputStream().print("YI");
        return false;
    }
}
