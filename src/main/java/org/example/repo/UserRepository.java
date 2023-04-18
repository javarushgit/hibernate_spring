package org.example.repo;

import org.example.jdbctemplate.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findAllByNameContaining(String pattern);

    @Query("from Address where city = 'Kyiv' and user.id = id")
    List<User> hello();
}
