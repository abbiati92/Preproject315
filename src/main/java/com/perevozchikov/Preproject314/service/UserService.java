package com.perevozchikov.Preproject314.service;


import com.perevozchikov.Preproject314.model.User;

import java.util.Set;

public interface UserService {
    Set<User> getUsers();
    User getUser(Integer id);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Integer id);
    User findByUserEmail(String email);
}
