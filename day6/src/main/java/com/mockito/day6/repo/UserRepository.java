package com.mockito.day6.repo;

import java.util.Optional;

import com.mockito.day6.model.User;

public interface UserRepository {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User save(User user);

}
