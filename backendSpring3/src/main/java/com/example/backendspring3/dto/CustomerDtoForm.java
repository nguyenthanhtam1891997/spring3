package com.example.backendspring3.dto;

import com.example.backendspring3.validation.EmailValidator;

public class CustomerDtoForm {

    private String userName;

    @EmailValidator
    private String email;
    private String password;

    private String address;
    private String phone;

    public CustomerDtoForm() {
    }

    public CustomerDtoForm(String userName, String email, String password, String address, String phone) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
