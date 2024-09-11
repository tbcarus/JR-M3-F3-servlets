package ru.tbcarus.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.dao.UserDao;
import ru.tbcarus.quest.model.User;

import java.util.List;

@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    private final BCryptPasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        userDao.save(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUser(String login, String password) {
        List<User> users = getUsers();

        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .findFirst().orElse(null);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
