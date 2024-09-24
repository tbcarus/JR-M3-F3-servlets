package ru.tbcarus.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.tbcarus.quest.dao.UserDao;
import ru.tbcarus.quest.model.User;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static ru.tbcarus.quest.UserTestData.*;

class UserServiceTest {

    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    UserService userService = new UserService(
            new UserDao(objectMapper,  new File("C:/projects/JR/Module-3/JR-M3-F3-servlets/src/main/resources/Users-test.yaml")),
            new BCryptPasswordEncoder());

    @BeforeEach
    void setUp() {
        userService.deleteAllUsers();
        userService.saveAllUsers(users);
    }

    @Test
    void saveUser() {
        User newUser = getNew();
        userService.saveUser(newUser);
        Optional<User> opt = userService.getUser(newUser.getLogin(), newUser.getPassword());
        assertTrue(opt.isPresent());
        assertEquals(newUser.getId(), opt.get().getId());
        assertEquals(newUser.getLogin(), opt.get().getLogin());
    }

    @Test
    void getUsers() {
        List<User> usersFromDao = userService.getUsers();
        assertEquals(users.size(), usersFromDao.size());
    }

    @Test
    void getUser() {
        Optional<User> opt = userService.getUser(user1.getLogin(), user1.getPassword());
        assertTrue(opt.isPresent());
        assertEquals(user1.getId(), opt.get().getId());
        assertEquals(user1.getLogin(), opt.get().getLogin());
    }

    @Test
    void deleteUser() {
        User userToDelete = userService.getUser(user3.getLogin(), user3.getPassword()).get();
        userService.deleteUser(userToDelete);
        Optional<User> opt = userService.getUser(user3.getLogin(), user3.getPassword());
        assertFalse(opt.isPresent());
    }

    @Test
    void isExist() {
        boolean exist = userService.isExist(user1.getLogin());
        assertTrue(exist);
    }
}