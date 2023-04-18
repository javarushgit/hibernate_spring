package org.example.jdbctemplate.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.example.hibernate.HibernateUtil;
import org.example.jdbctemplate.UserMapper;
import org.example.jdbctemplate.model.Address;
import org.example.jdbctemplate.model.User;
import org.example.jdbctemplate.repository.SQLQueries;
import org.example.jdbctemplate.repository.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;
  //  private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }


//    @Override
//    public Optional<User> findById(Long id) {
//        return Objects.requireNonNull(
//                jdbcTemplate.query(
//                       SQLQueries.USER_FIND_BY_ID,
//                       new Object[]{id},
//                       new UserMapper(jdbcTemplate)
//                )
//        ).stream().findAny();
//    }


}
