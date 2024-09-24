package ru.tbcarus.quest.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String login;
    private String password;

    public User(User u) {
        this.id = u.getId();
        this.login = u.getLogin();
        this.password = u.getPassword();
    }
}