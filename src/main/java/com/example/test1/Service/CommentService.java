package com.example.test1.Service;

import com.example.test1.Domain.Comment;

import java.util.List;

public interface CommentService {
    Comment add(Comment comment);
    Comment update(Long id, Comment comment);
    boolean delete(Long id);
    Comment View(Long id);
    List<Comment> list();
}
