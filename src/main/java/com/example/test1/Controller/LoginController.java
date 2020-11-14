package com.example.test1.Controller;

import com.example.test1.Domain.User;
import com.example.test1.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/login", produces="text/xml;charset=UTF-8", method=RequestMethod.POST)
    public void login(@RequestBody User user, HttpServletRequest req, HttpServletResponse res) throws IOException {
        loginService.login(user.getEmail(), user.getPassword(), req, res);
    }
}
