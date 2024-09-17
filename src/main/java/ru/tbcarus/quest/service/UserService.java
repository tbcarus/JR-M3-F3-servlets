package ru.tbcarus.quest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.dao.UserDao;
import ru.tbcarus.quest.model.User;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUser(String login, String password) {
        List<User> users = getUsers();

        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> passwordEncoder.matches(password, u.getPassword()))
                .findFirst();
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public boolean isExist(String login) {
        return getUsers().stream().map(User::getLogin).anyMatch(l -> l.equals(login));
    }
}
