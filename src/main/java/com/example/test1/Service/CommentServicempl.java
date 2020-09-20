package com.example.test1.Service;

import com.example.test1.Domain.Comment;
import com.example.test1.Protocol.CommentUserProtocol;
import com.example.test1.Repository.CommentRepository;
import com.example.test1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicempl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommentUserProtocol add(Comment comment) {
        return new CommentUserProtocol(
                commentRepository.save(comment),
                userRepository.findById(comment.getUser_id())
                    .map(found -> found.getUserName())
                    .orElse(null));
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public CommentUserProtocol update(Long id, Comment comment) {
        return null;
    }

    @Override
    public CommentUserProtocol view(Long id) {
        return null;
    }

    @Override
    public List<CommentUserProtocol> listAllComments() {
        return null;
    }
}
