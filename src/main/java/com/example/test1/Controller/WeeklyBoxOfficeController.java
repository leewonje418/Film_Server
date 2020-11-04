package com.example.test1.Controller;

import com.example.test1.Api.WeeklyBoxOfficeClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeeklyBoxOfficeController {
    private final WeeklyBoxOfficeClient weeklyboxofficeclient;
    @GetMapping("/api/v1/weeklyboxoffice/{keyword}")
    public String get(@PathVariable String keyword) throws JsonProcessingException {
        return weeklyboxofficeclient.requestWeeklyBoxOffice(keyword);
    }
}
