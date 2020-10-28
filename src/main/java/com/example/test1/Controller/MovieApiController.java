package com.example.test1.Controller;

import com.example.test1.Api.MovieApiClient;
import com.example.test1.Domain.MoviesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieApiController<MoviesService> {
    private final MovieApiClient movieApiClient;
    private final MoviesService moviesService;
    @GetMapping("/api/v1/movies/{keyword}")
    public MoviesDto get(@PathVariable String keyword) {
        return movieApiClient.requestMovie(keyword);
    }
}
