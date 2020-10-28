package com.example.test1.Api;

import com.example.test1.Domain.MoviesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
public class MovieApiClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String CLIENT_ID = "BJQYpubXwcJYe46wRXsl";
    private final String CLIENT_SECRET = "luc9N7726n";
    private final String api = "https://openapi.naver.com/v1/search/movie.json?query={keyword}";
    public MoviesDto requestMovie(String keyword) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(api, HttpMethod.GET, entity, MoviesDto.class, keyword).getBody();
    }
}
