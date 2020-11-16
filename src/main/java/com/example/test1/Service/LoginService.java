package com.example.test1.Service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    boolean login(String email, String password, Model model, HttpServletRequest req, HttpServletResponse res);
}
