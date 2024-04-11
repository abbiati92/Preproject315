package com.perevozchikov.Preproject314.security;

import com.perevozchikov.Preproject314.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomGrantedAuthority implements GrantedAuthority {
    private Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }
}
