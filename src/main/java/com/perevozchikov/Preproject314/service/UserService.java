package com.perevozchikov.Preproject314.service;

import com.perevozchikov.Preproject314.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getUsersList();
    User getUser(Long id);
    void addUser(User user, String[] selectResult);

    void addCurrentUser(User user);
    void deleteUser(Long id);
    void editUser(User user, String [] selectResult);
    User findByUsername(String username);
}
