package org.example.jdbctemplate.repository;

import org.example.jdbctemplate.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setCity(rs.getString("city"));
        address.setId(rs.getLong("id"));
        address.setCountry(rs.getString("country"));
        address.setState(rs.getString("street"));
        address.setState(rs.getString("state"));
        return address;
    }
}
