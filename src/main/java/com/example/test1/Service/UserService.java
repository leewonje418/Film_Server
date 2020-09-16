package com.example.test1.Service;

import com.example.test1.Domain.User;

import java.util.List;

public interface UserService {
    User add(User user);
    User login(String email, String password);
    User update(Long id, User user);
    boolean delete(Long id);
    User View(Long id);
    List<User> list();
}
