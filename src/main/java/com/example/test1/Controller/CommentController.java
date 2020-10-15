package com.example.test1.Controller;

import com.example.test1.Domain.Comment;
import com.example.test1.Domain.User;
import com.example.test1.Protocol.CommentUserProtocol;
import com.example.test1.Service.CommentService;
import com.example.test1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/comment/add")
    public CommentUserProtocol add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }
    @PutMapping("/comment/update/{id}")
    public CommentUserProtocol update(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }
    @DeleteMapping("/comment/delete/{id}")
    public boolean remove(@PathVariable Long id) {
        return commentService.delete(id);
    }
    @GetMapping("/comment/view/{id}")
    public CommentUserProtocol view(@PathVariable Long id) {
        return commentService.view(id);
    }
    @GetMapping("/comment/list")
    public List<CommentUserProtocol> listAllComments() {
        return commentService.listAllComments();
    }
}
