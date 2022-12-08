package com.network.backend.service;

import com.google.common.hash.Hashing;
import com.network.backend.dao.UserDataAccessService;
import com.network.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserService {

    private final UserDataAccessService userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDataAccessService userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
        UUID id = UUID.randomUUID();

        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String create_date = date.format(dateFormatter);

        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String create_time = time.format(timeFormatter);

        String hashedPassword = hashingPassword(user.getPassword());

        return userDao.insertUser(id, create_date, create_time, hashedPassword, user);
    }

    public String hashingPassword(String password) {

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
        int upperBound = salts.length - 1;
        int randomNum = random.nextInt(upperBound);
        String salt = salts[randomNum];

        String hashingPassword0 = Hashing.sha256()
                .hashString(password + salt, StandardCharsets.UTF_8)
                .toString();

        String hashingPassword1 = Hashing.sha256()
                .hashString(hashingPassword0, StandardCharsets.UTF_8)
                .toString();

        String hashingPassword2 = Hashing.sha256()
                .hashString(hashingPassword1, StandardCharsets.UTF_8)
                .toString();

        String hashedPassword = hashingPassword2 + salt;

        return hashedPassword;
    }

    public List<User> getUserByUsername(String username, String password) {
        return userDao.selectUserByUsername(username,password);
    }

    public int deleteUser(UUID id) {
        return userDao.deleteUSerById(id);
    }

    public int updateUser(UUID id, User newUser) {
        return userDao.updateUserPasswordById(id, newUser);
    }

}
