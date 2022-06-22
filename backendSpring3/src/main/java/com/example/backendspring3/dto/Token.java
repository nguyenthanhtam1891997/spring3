package com.example.backendspring3.dto;

public class Token {

    private String userName;
    private String token;

    public Token(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public Token() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
