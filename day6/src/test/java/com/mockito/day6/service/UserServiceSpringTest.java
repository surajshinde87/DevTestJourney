package com.mockito.day6.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.day6.model.User;
import com.mockito.day6.repo.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceSpringTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void registerUser_withMockBean() {
        User user = new User();
        user.setUsername("Suraj");
        user.setEmail("suraj@test.com");

        when(userRepository.save(any())).thenReturn(user);

        User saved = userService.registerUser(user);

        assertEquals("Suraj", saved.getUsername());
        verify(userRepository, times(1)).save(any());
    }
}