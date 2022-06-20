package com.example.backendspring3.dto;

public class Token {

    private String token;

    public Token(String tokenValue) {
        this.token = tokenValue;
    }

    public Token() {
    }

    public String getTokenValue() {
        return token;
    }

    public void setTokenValue(String tokenValue) {
        this.token = tokenValue;
    }
}
