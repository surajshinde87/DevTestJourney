package com.mockito.day6.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.day6.model.User;
import com.mockito.day6.repo.UserRepository;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {


@Mock
private UserRepository userRepository;


@InjectMocks
private UserService userService;


private User user;


@BeforeEach
void setup() {
user = new User(1L, "suraj", "suraj@gmail.com", "pwd");
}


@Test
void registerUser_success() {
when(userRepository.findByUsername("suraj")).thenReturn(Optional.empty());
when(userRepository.findByEmail("suraj@gmail.com")).thenReturn(Optional.empty());
when(userRepository.save(any(User.class))).thenReturn(user);


User saved = userService.registerUser(user);


assertNotNull(saved);
assertEquals("suraj", saved.getUsername());
verify(userRepository).save(any(User.class));
}


@Test
void registerUser_usernameExists_throws() {
when(userRepository.findByUsername("suraj")).thenReturn(Optional.of(user));


IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
() -> userService.registerUser(user));
assertEquals("Username already exists", ex.getMessage());
verify(userRepository, never()).save(any());
}


@Test
void isUsernameAvailable_falseWhenExists() {
when(userRepository.findByUsername("suraj")).thenReturn(Optional.of(user));
assertFalse(userService.isUsernameAvailable("suraj"));
}
}