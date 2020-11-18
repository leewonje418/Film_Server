package com.example.test1.Service;

import com.example.test1.Domain.User;
import com.example.test1.http.Response;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface LoginAndLogoutService {
    User login(String email, String password, Model model, HttpServletRequest req, HttpServletResponse res);
    Response logout(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
