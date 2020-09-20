package com.example.test1.Protocol;

import com.example.test1.Domain.Comment;
import lombok.Data;

@Data
public class CommentUserProtocol extends Comment {
    private String username;
    public CommentUserProtocol(Comment c, String username) {
        super(c);
        this.username = username;
    }
}
