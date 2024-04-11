package com.perevozchikov.Preproject314.repository;

import com.perevozchikov.Preproject314.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository {

    User findByUserEmail(String email);
    Set<User> getUsers();
    User getUser(Integer id);
    void removeUser(Integer id);
    void addUser(User user);
    void updateUser(User user);
}
