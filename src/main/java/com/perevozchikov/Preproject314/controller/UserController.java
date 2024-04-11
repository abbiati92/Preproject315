package com.perevozchikov.Preproject314.controller;

import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserRepositoryImpl userRepository;

    @Autowired
    public UserController(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String followUser(Model model, Principal principal) {
        User user = userRepository.findByUserEmail(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }
}