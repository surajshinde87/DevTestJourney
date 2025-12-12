package com.mockito.day7.service;

import com.mockito.day7.dto.UserDto;

public interface UserService {

    UserDto getUser(Long id);
    UserDto createUser(UserDto user);
    
}