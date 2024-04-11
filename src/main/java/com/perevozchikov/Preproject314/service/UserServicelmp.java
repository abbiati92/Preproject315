package com.perevozchikov.Preproject314.service;

import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServicelmp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServicelmp(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getPassword() == "") {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Integer id) {
        userRepository.removeUser(id);
    }

    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email);
    }
}