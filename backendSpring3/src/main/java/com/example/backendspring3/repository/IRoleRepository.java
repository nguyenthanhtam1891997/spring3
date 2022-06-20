package com.example.backendspring3.repository;

import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(RoleName name);
}
