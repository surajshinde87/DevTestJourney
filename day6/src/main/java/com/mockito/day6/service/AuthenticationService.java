package com.mockito.day6.service;

import com.mockito.day6.model.User;
import com.mockito.day6.repo.AuthRepository;

public class AuthenticationService {

    private final AuthRepository repo;

    public AuthenticationService(AuthRepository repo) {
        this.repo = repo;
    }

    public String login(String username, String password) {
        User u = repo.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (!u.getPassword().equals(password))
            throw new IllegalArgumentException("Invalid credentials");
        return "token-" + u.getId();
    }
}
