package com.example.backendspring3.service;

import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.RoleName;

public interface IRoleService {
    Role findByRole(RoleName name);
}
