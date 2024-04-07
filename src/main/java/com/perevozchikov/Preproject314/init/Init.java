package com.perevozchikov.Preproject314.init;

import com.perevozchikov.Preproject314.model.Role;
import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.service.RoleService;
import com.perevozchikov.Preproject314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Init {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        roleService.addRole(userRole);

        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");
        roleService.addRole(adminRole);

        Set<Role> userRoles = new HashSet<>(List.of(userRole));
        Set<Role> adminRoles = new HashSet<>(List.of(adminRole));

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("adminov");
        admin.setEmail("admin@mail.ru");
        admin.setUserPassword("admin");
        admin.setRoles(adminRoles);
        userService.addCurrentUser(admin);

        User user = new User();
        user.setFirstName("user");
        user.setLastName("userov");
        user.setEmail("user@mail.ru");
        user.setUserPassword("user");
        user.setRoles(userRoles);
        userService.addCurrentUser(user);
    }
}
