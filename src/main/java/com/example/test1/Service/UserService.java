package com.example.test1.Service;

import com.example.test1.Domain.User;
import com.example.test1.http.Response;

import java.util.List;

public interface UserService {
    User add(User user);
    User login(String email, String password);
    User update(Long id, User user);
    Response delete(Long id);
    User View(Long id);
    List<User> list();
    Response emailcheck(String email);
}
