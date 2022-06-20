package com.example.backendspring3.service.impl;

import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.RoleName;
import com.example.backendspring3.repository.IRoleRepository;
import com.example.backendspring3.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findByRole(RoleName name) {
        return roleRepository.findByRole(name);
    }
}
