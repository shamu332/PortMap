package com.network.backend.dao;

import com.network.backend.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, String create_date, String create_time, User user) {
        DB.add(new User(id, user.getUsername(), user.getFirst_name(), user.getLast_name(), user.getPassword(), user.getEmail(), create_date, create_time));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUSerById(UUID id) {
        Optional<User> userMaybe = selectUserById(id);
        if (userMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserPasswordById(UUID id, User update) {
        return selectUserById(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.indexOf(user);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(id, user.getUsername(), user.getFirst_name(), user.getLast_name(), update.getPassword(), user.getEmail(), user.getCreate_date(), user.getCreate_time()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
