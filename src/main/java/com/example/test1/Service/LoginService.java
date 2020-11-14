package com.example.test1.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    boolean login(String email, String password, HttpServletRequest req, HttpServletResponse res);
}
