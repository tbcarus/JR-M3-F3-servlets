package ru.tbcarus.quest.model;

import lombok.Getter;

@Getter
public enum Phase {
    WIN("Победа"),
    LOSE("Проигрышь"),
    NEXT("Следующая фаза");

    private String description;

    Phase(String description) {
        this.description = description;
    }
}
