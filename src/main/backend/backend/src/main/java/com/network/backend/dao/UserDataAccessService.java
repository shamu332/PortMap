package com.network.backend.dao;

import com.network.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDao{


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, String create_date, String create_time, User user) {
        return 0;
    }

    @Override
    public List<User> selectAllUser() {
        final String sql = "select * from users";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String username = resultSet.getString("username");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String create_date = resultSet.getString("create_date");
                    String create_time = resultSet.getString("create_time");
                    return new User(id, username, first_name, last_name,password, email, create_date, create_time);
        });
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteUSerById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserPasswordById(UUID id, User user) {
        return 0;
    }
}
