package com.example.findtutor.service;

import com.example.findtutor.model.user.Role;
import com.example.findtutor.model.user.MyUser;

import java.util.List;

public interface UserService {
    MyUser saveUser(MyUser user);
    Role saveRole(Role role);
    void assignRole(String username, String roleName);
    MyUser getUser(String username);
    List<MyUser> getAllUsers();
}
