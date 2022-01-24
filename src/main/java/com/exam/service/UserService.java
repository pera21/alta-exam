package com.exam.service;

import java.util.List;

import com.exam.model.User;

public interface UserService {

    List<User> getAll();
    User newUser(User user);
    User retrieveById(Long userId);
    void deleteUser(Long userId);
    
}
