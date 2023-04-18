package org.example.jdbctemplate.repository;

public class SQLQueries {
    public static final String USER_FIND_ALL = "SELECT * FROM user u JOIN address a ON u.id = a.user_id";
    public static final String USER_FIND_BY_ID = "SELECT * FROM user u JOIN address a ON u.id = a.user_id WHERE u.id = ?";
}
