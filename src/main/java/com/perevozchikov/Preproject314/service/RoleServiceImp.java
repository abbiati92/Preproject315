package com.perevozchikov.Preproject314.service;


import com.perevozchikov.Preproject314.model.Role;
import com.perevozchikov.Preproject314.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getRoles() {
        return roleRepository.getRoles();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }
}