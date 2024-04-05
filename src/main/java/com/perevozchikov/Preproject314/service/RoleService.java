package com.perevozchikov.Preproject314.service;

import com.perevozchikov.Preproject314.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    Role getRoleForName(String name);
    Role getRoleById(Long id);

    void addRole(Role roleUser);
}
