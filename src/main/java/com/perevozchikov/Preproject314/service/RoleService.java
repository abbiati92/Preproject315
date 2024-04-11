package com.perevozchikov.Preproject314.service;

import com.perevozchikov.Preproject314.model.Role;

import java.util.Set;
public interface RoleService {
    Set<Role> getRoles();
    Role findById(Integer id);
    void addRole(Role role);
}