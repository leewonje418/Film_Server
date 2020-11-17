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
                             HttpServletResponse response,
                             Object handler) throws IOException {
        HttpSession httpSession = request.getSession();
        System.out.println(httpSession);
        System.out.println(httpSession.getAttribute("sessionId"));
        if (httpSession.getAttribute("sessionId") != null) {
            response.getOutputStream().print("YAY");
            return true;
        } else {
            response.getOutputStream().print("YI");
        }
        return false;
    }
}
