package org.example.jdbctemplate;

import lombok.RequiredArgsConstructor;
import org.example.jdbctemplate.model.Address;
import org.example.jdbctemplate.model.User;
import org.example.jdbctemplate.repository.AddressMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class UserMapper implements RowMapper<User> {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setAddresses(new ArrayList<>(getAddressForUser(user.getId())));
        user.setName(rs.getString("name"));
        return user;
    }

    private List<Address> getAddressForUser(Long id) {
        return jdbcTemplate.query("select * from address where id = ? AND city = 'Kyiv'", new Object[]{id}, new AddressMapper());
    }

}
