package com.mockito.day6.repo;

import java.util.Optional;

import com.mockito.day6.model.User;

public interface AuthRepository {

    Optional<User> findByUsername(String username);
}
