package com.cinema.repository.user;

import com.cinema.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> save(User user);

    Optional<User> findByEmailAndPassword(String email, String password);
}
