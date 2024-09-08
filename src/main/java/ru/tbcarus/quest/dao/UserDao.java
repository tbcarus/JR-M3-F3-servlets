package ru.tbcarus.quest.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class UserDao {

    private final ObjectMapper objectMapper;
    private final File file;

    public void save(User user) {
        try {
            List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {});
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(user);
            objectMapper.writeValue(file, users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUsers() {
        List<User> users = null;

        try {
            users = objectMapper.readValue(file, new TypeReference<List<User>>() {});
            if (users == null) {
                users = new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
