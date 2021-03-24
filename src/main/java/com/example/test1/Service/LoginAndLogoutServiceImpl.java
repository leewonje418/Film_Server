package com.example.test1.Service;

import com.example.test1.Domain.User;
import com.example.test1.Repository.UserRepository;
import com.example.test1.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Service
public class LoginAndLogoutServiceImpl implements LoginAndLogoutService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Response login(String email, String password, Model model, HttpServletRequest req, HttpServletResponse res) {
        Optional<User> user = userRepository.findByEmail(email);
        HttpSession session = req.getSession();
        try {
            if (user.isPresent() && user.get().getPassword().equals(password)) {
                if(session == null || session.getAttribute("sessionId") == null) {
                    session.setAttribute("sessionId", email);
                    session.setMaxInactiveInterval(60*60*24*3);
                    return new Response(HttpStatus.OK, "사용 가능한 이메일");
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

    @Override
    public Response logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        return new Response(HttpStatus.MOVED_PERMANENTLY, "로그아웃 성공");
    }

}
