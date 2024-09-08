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
}