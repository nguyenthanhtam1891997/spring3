package com.example.backendspring3.dto;

import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.User;
import lombok.*;

import java.util.List;

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public interface JoinCustomerDto {

    String getName();

    String getPhone();

    String getUserName();

    String getEmail();

    String getAvatar();

}
