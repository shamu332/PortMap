package com.network.backend.dao;


import com.network.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int insertUser(UUID id, String create_date, String create_time, String hashedPassword, User user) {


        String sql = "" +
                "INSERT INTO users (" +
                " id, " +
                " username, " +
                " first_name, " +
                " last_name, " +
                " password, " +
                " email, " +
                "create_date, " +
                "create_time) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                user.getUsername(),
                user.getFirst_name(),
                user.getLast_name(),
                hashedPassword,
                user.getEmail(),
                create_date,
                create_time
        );
    }


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
                    return new User(id, username, first_name, last_name,password, email);
        });
    }



//    public int selectUserByUsername(User user) {
//        String sql = "select " + " username" + ", password from users where username = ?";
//        int q = jdbcTemplate.update(sql, user.getUsername());
//        return (resultSet, i) -> {
//            String username = resultSet.getString("username");
//            String password = resultSet.getString("password");
//        };
//    }


    public int deleteUSerById(UUID id) {
        return 0;
    }


    public int updateUserPasswordById(UUID id, User user) {
        return 0;
    }

}
