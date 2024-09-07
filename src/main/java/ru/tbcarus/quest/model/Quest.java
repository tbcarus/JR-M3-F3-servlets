package ru.tbcarus.quest.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Quest {
    private String name;
    private String story;
    private Map<Integer, Stage> quest;

    public Stage getStage(int n) {
        return quest.get(n);
    }

    public void addStage(Stage s) {
        quest.put(s.getId(), s);
    }
}
