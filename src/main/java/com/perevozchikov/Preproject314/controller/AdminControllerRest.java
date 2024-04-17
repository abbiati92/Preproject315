package com.perevozchikov.Preproject314.controller;

import com.perevozchikov.Preproject314.model.Role;
import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.service.RoleService;
import com.perevozchikov.Preproject314.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class AdminControllerRest {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminControllerRest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/showAccount")
    public ResponseEntity<User> showInfoUser(Principal principal) {
        return ResponseEntity.ok(userService.findByUserEmail(principal.getName()));
    }

    @GetMapping("/users")
    public ResponseEntity<Set<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Set<Role>> getRole(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody @Valid User newUser, BindingResult bindingResult) {
        userService.addUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser (@RequestBody User userFromWebPage, @PathVariable("id") Integer id) {
        userService.updateUser(userFromWebPage);
        return new ResponseEntity<>(userFromWebPage, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}