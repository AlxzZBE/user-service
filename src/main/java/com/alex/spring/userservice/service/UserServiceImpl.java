package com.alex.spring.userservice.service;

import com.alex.spring.userservice.domain.Role;
import com.alex.spring.userservice.domain.User;
import com.alex.spring.userservice.repository.RoleRepository;
import com.alex.spring.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user `{}` to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role `{}` to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role `{}` to user `{}`", roleName, username);
        userRepository.findByUsername(username)
                .ifPresent(u -> u.getRoles().add(roleRepository.findByName(roleName).get()));
    }

    @Override
    public User getUserByUsername(String username) {
        log.info("Fetching user `{}`", username);
        return userRepository.findByUsername(username).get();
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
