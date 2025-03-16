package com.example.CarProject.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthResponse {
    private String token;

    private String redirectUrl;

    public AuthResponse(String token, String redirectUrl) {
        this.token = token;
        this.redirectUrl = redirectUrl;
    }
}
