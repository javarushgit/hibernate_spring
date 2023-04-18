package org.example.service;

import org.example.jdbctemplate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getById(long id);
    List<User> m(String s);
}
