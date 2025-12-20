package com.mockito.day7.service.impl;

import org.springframework.stereotype.Service;
import com.mockito.day7.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String username, String password) {
        return "token";
    }
}
