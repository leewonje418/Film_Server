package com.example.test1.Repository;

import com.example.test1.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

    List<Comment> findAllByMovieNameAndDirector(String movieName, String director);
}
