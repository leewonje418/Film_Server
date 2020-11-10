package com.example.test1.Controller;

import com.example.test1.Api.WeeklyBoxOfficeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeeklyBoxOfficeController {
    private final WeeklyBoxOfficeClient weeklyboxofficeclient;
    @GetMapping("/api/v1/weeklyboxoffice/{keyword}")
    public Map get(@PathVariable String keyword) throws Exception {
        return weeklyboxofficeclient.requestWeeklyBoxOffice(keyword);
    }
}
