package com.example.test1.Service;

import com.example.test1.Domain.User;
import com.example.test1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User login(String email, String password, Model model, HttpServletRequest req, HttpServletResponse res) {
        Optional<User> user = userRepository.findByEmail(email);
        HttpSession session = req.getSession();
        try {
            if (user.isPresent() && user.get().getPassword().equals(password)) {
                if(session == null || session.getAttribute("sessionId") == null) {
                    session.setAttribute("sessionId", email);
                    session.setMaxInactiveInterval(60*60*24*3);
                    System.out.println(session);
                    System.out.println(session.getAttribute("sessionId"));
                    System.out.println(user.get());
                    return user.get();
                }
            } else {
                res.setStatus(400);
                res.setContentType("text/xml;charset=UTF-8");
                res.setCharacterEncoding("utf-8");
                res.getWriter().write("아이디 또는 비밀번호가 올바르지 않습니다.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
