package com.network.backend.dao;
import com.network.backend.model.User;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(UUID id, String create_date, String create_time, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String create_date = date.format(dateFormatter);
        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String create_time = time.format(timeFormatter);
        return insertUser(id, create_date, create_time, user);
    }

    List<User> selectAllUser();

    Optional<User> selectUserById(UUID id);

    int deleteUSerById (UUID id);

    int updateUserPasswordById(UUID id, User user);

}
