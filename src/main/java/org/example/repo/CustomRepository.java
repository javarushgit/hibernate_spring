package org.example.repo;

import org.example.jdbctemplate.model.User;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface CustomRepository {
    List<User> findAllByName(String name);
}
