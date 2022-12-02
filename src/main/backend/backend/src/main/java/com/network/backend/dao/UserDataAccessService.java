package com.network.backend.dao;

import com.google.common.hash.Hashing;
import com.network.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Random;
import java.nio.charset.StandardCharsets;
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

        String[] salts = {
                "T#q;%5!P^3",
                "&#U-H7YaP^",
                "$B2p+9dKnE",
                "Ja_8uM++3P",
                "6UNDr=QvLK",
                "kvYP&uP8_P",
                "Egj74mE$4J",
                "zxK-3@*cA*",
                "-Gp^-n$33s",
                "&_dd2LUeh3",
                "AV8ET=%snJ",
                "z$B6&9rkh4",
                "Xzfr!f66FS",
                "sF7kkJ$G&q",
                "6#P!Um9Vn*",
                "@%Fdh5D%Yd",
                "^2*cAm2_yf",
                "QvvFjH^j5X",
                "J4VsJ#Yzka",
                "-FjCQkfP9$",
                "eJkac8p_^X"
        };

        Random random = new Random();

        int upperBound = 19;

        int randomNum = random.nextInt(upperBound);

        String salt = salts[randomNum];

        String hashingPassword0 = Hashing.sha256()
                .hashString(user.getPassword() + salt, StandardCharsets.UTF_8)
                .toString();

        String hashingPassword1 = Hashing.sha256()
                .hashString(hashingPassword0, StandardCharsets.UTF_8)
                .toString();

        String hashingPassword2 = Hashing.sha256()
                .hashString(hashingPassword1, StandardCharsets.UTF_8)
                .toString();

        String hashedPassword = hashingPassword2 + salt;


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
