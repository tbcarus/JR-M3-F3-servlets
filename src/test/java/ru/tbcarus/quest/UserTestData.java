package ru.tbcarus.quest;

import ru.tbcarus.quest.model.User;

import java.util.List;
import java.util.UUID;

public class UserTestData {

    public static User getNew() {
        return new User(UUID.randomUUID(), "New", "NewPass");
    }

    public static User user1 = new User(UUID.randomUUID(), "User1", "pass1");
    public static User user2 = new User(UUID.randomUUID(), "User2", "pass2");
    public static User user3 = new User(UUID.randomUUID(), "User3", "pass3");

    public static List<User> users = List.of(user1, user2, user3);
}
