package com.exam.service;

import java.util.List;
import java.util.Optional;

import com.exam.exception.ResourceNotFoundException;
import com.exam.model.User;
import com.exam.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User newUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User retrieveById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            return user.get();
        }else{
            throw new ResourceNotFoundException("User", "Id", userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.deleteById(userId);
        }else{
            throw new ResourceNotFoundException("User", "Id", userId);
        } 
    }
    
}
