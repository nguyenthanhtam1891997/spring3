package com.example.backendspring3.service;

import com.example.backendspring3.model.User;

public interface IUserService {
    User findByEmail(String email);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    User save(User user);
}
