package com.example.test1.Controller;

import com.example.test1.Api.DailyBoxOfficeClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DailyBoxOfficeController {
    private final DailyBoxOfficeClient dailyBoxOfficeClient;
    @GetMapping("/api/v1/dailyboxoffice/{keyword}")
    public Map get(@PathVariable String keyword) throws JsonProcessingException {
        return dailyBoxOfficeClient.requestDailyBoxOffice(keyword);
    }
}
