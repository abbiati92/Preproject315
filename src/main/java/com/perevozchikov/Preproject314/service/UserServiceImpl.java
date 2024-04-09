package com.perevozchikov.Preproject314.service;

import com.perevozchikov.Preproject314.model.Role;
import com.perevozchikov.Preproject314.model.User;
import com.perevozchikov.Preproject314.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    public void addUser(User user, String[] selectResult) {
        Set<Role> roles = new HashSet<>();
        for (String s : selectResult) {
            roles.add(roleService.getRoleForName("ROLE_" + s));
            user.setRoles(roles);
        }
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void addCurrentUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user, String[] selectResult) {
        Set<Role> roles = new HashSet<>();
        for (String s : selectResult) {
            roles.add(roleService.getRoleForName("ROLE_" + s));
            user.setRoles(roles);
        }
        userDao.editUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isEnabled(), user.isAccountNonLocked(),
                user.getRoles());
    }
}
