package com.example.test1.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response {
    private int status;
    private String message;

    public Response(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }
}
