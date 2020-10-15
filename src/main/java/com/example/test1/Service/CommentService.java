package com.example.test1.Service;

import com.example.test1.Domain.Comment;
import com.example.test1.Protocol.CommentUserProtocol;

import java.util.List;

public interface CommentService {
    CommentUserProtocol add(Comment comment);

    boolean delete(Long id);

    CommentUserProtocol update(Long id, Comment comment);

    CommentUserProtocol view(Long id);

    List<CommentUserProtocol> listAllComments();
}
