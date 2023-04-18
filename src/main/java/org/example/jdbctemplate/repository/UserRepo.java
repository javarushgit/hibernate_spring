package org.example.jdbctemplate.repository;

import org.example.jdbctemplate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    List<User> findAll();
    Optional<User> findById(Long id);
}
