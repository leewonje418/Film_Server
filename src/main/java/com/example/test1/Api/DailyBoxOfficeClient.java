package com.example.test1.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class DailyBoxOfficeClient {
    private RestTemplate restTemplate = new RestTemplate();
    private final String api = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=8731a2a39a8f057b67ee66bfa1a0f959&targetDt={keyword}";
    public String requestDailyBoxOffice(String keyword) throws JsonProcessingException {
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=430156241533f1d058c603178cc3ca0e&targetDt="+keyword).build();

        //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
        result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); //헤더 정보 확인
        result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

        //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(resultMap.getBody());
        return jsonInString;
    }
}
