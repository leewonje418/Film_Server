package com.example.test1.Service;

import com.example.test1.Domain.User;
import com.example.test1.Repository.UserRepository;
import com.example.test1.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User add(User user) {
        Optional<User>found = userRepository.findByEmail(user.getEmail());
        if(found.isPresent()) return null;
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            if(user.get().getPassword().equals(password)) return user.get();
        }
        return null;
    }

    @Override
    public Response update(Long id, User user) {
        userRepository.findById(id).map(found -> {
            found.setUsername(Optional.ofNullable(user.getUsername()).orElse(found.getUsername()));
            found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
            found.setUsername(Optional.ofNullable(user.getUsername()).orElse(found.getUsername()));
            found.setStoredPath(Optional.ofNullable(user.getStoredPath()).orElse(found.getStoredPath()));
            userRepository.save(found);
            return new Response(HttpStatus.MOVED_PERMANENTLY, "계정 삭제 성공!");
        }).orElse(null);
        return null;
    }

    @Override
    public Response delete(Long id) {
        try {
            userRepository.deleteById(id);
            return new Response(HttpStatus.MOVED_PERMANENTLY, "계정 삭제 성공!");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User View(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public Response emailcheck(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && user != null) {
            return new Response(HttpStatus.CONFLICT, "중복된 이메일.");
        } else {
            return new Response(HttpStatus.OK, "사용 가능한 이메일");
        }
    }

    @Override
    public Response nicknamecheck(String nickname) {
        Optional<User> user = userRepository.findByNickname(nickname);
        if(user.isPresent() && user != null) {
            return new Response(HttpStatus.CONFLICT, "중복된 닉네임.");
        } else {
            return new Response(HttpStatus.OK, "사용 가능한 닉네임");
        }
    }
}
