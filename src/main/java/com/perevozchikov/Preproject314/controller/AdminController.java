package com.perevozchikov.Preproject314.controller;

import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.service.RoleService;
import com.perevozchikov.Preproject314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public String getUsers(ModelMap model, Principal principal) {
        User user = userService.findByUserEmail(principal.getName());
        model.addAttribute("user", user);
        Set<User> list = userService.getUsers();
        model.addAttribute("list", list);
        model.addAttribute("roles", roleService.getRoles());
        return "users";
    }


    @PostMapping("/")
    public String addUser(@ModelAttribute("user") @Valid User user, @RequestParam(name = "name_role", required = false) Integer[] roles) {
        user.setRoles(Arrays.stream(roles).map(roleService::findById).collect(Collectors.toSet()));
        userService.addUser(user);
        return "redirect:/admin/";
    }

    @PatchMapping("/{id}")
    public String saveUpdateUser(@ModelAttribute("user") @Valid User user, @RequestParam(name = "name_role", required = false) Integer[] roles ) {
        user.setRoles(Arrays.stream(roles).map(roleService::findById).collect(Collectors.toSet()));
        userService.updateUser(user);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/admin/";
    }
}