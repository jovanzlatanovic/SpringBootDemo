package com.jovan.userservice.service;

import com.jovan.userservice.model.Role;
import com.jovan.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}
