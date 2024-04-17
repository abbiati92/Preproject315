package com.perevozchikov.Preproject314.controller;

import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserControllerRest {

    private final UserService userService;

    @Autowired
    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showAccount")
    public ResponseEntity<User> showAccount(Principal principal) {
        User user = userService.findByUserEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}