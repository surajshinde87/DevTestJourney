package com.mockito.day6.service;

import com.mockito.day6.model.User;
import com.mockito.day6.repo.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username already exists");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    public boolean isUsernameAvailable(String username){
        return userRepository.findByUsername(username).isEmpty();
    }
}
