package com.perevozchikov.Preproject314.repository;

import com.perevozchikov.Preproject314.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Repository
public interface RoleRepository {
    Set<Role> getRoles();

    @Transactional
    void addRole(Role role);

    Role findById(Integer id);
}