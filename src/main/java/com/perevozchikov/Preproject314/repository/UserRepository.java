package com.perevozchikov.Preproject314.repository;

import com.perevozchikov.Preproject314.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsersList();
    User getUser(Long id);
    void addUser(User user);
    void deleteUser(Long id);
    void editUser(User user);
    User findByUsername(String username);
}
