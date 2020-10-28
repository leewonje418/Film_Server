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
public class DailyBoxOfficeClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String api = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=8731a2a39a8f057b67ee66bfa1a0f959&targetDt={keyword}";
    public MoviesDto requestDailyBoxOffice(String keyword) {
        final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(api, HttpMethod.GET, entity, MoviesDto.class, keyword).getBody();
    }
}
