package com.mockito.day6.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.day6.model.User;
import com.mockito.day6.repo.AuthRepository;


@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {


@Mock
private AuthRepository authRepository;


@InjectMocks
private AuthenticationService authService;


@Test
void login_success() {
User u = new User(2L, "s", "s@g.com", "p");
when(authRepository.findByUsername("s")).thenReturn(Optional.of(u));


String token = authService.login("s", "p");
assertTrue(token.startsWith("token-"));
}


@Test
void login_wrongPassword_throws() {
User u = new User(3L, "x", "x@g.com", "p");
when(authRepository.findByUsername("x")).thenReturn(Optional.of(u));


assertThrows(IllegalArgumentException.class, () -> authService.login("x", "wrong"));
}


@Test
void login_userNotFound_throws() {
when(authRepository.findByUsername("rushi")).thenReturn(Optional.empty());
assertThrows(IllegalArgumentException.class, () -> authService.login("rushi", "r"));
}
}
