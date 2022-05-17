package com.alex.spring.userservice.service;

import com.alex.spring.userservice.domain.Role;
import com.alex.spring.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUserByUsername(String username);
    List<User> getUsers();

}
