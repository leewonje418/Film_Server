package com.example.test1.Controller;

import com.example.test1.Domain.User;
import com.example.test1.Service.LoginAndLogoutService;
import com.example.test1.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private LoginAndLogoutService loginAndLogoutService;
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public User login(@RequestBody User user, Model model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        return loginAndLogoutService.login(user.getEmail(), user.getPassword(), model, req, res);
    }

    @PostMapping("/logout")
    public Response logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
        return loginAndLogoutService.logout(req, res);
    }
}
