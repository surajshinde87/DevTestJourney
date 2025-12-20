package com.mockito.day7.service.impl;

import org.springframework.stereotype.Service;
import com.mockito.day7.service.UserService;
import com.mockito.day7.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto getUser(Long id) {
        return new UserDto(id, "Suraj", "suraj@example.com");
    }

    @Override
    public UserDto createUser(UserDto user) {
        return user;
    }
}
