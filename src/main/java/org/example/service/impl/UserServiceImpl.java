package org.example.service.impl;

import org.example.jdbctemplate.model.User;
import org.example.repo.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> m(String s) {
        return userRepository.findAllByNameContaining(s);
    }
}
