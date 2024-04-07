package com.perevozchikov.Preproject314.repository;

import com.perevozchikov.Preproject314.model.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getAllRoles();
    Role getRoleForName(String name);
    Role getRoleById(Long id);
    void addRole(Role role);
}
