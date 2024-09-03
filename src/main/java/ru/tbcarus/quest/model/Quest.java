package ru.tbcarus.quest.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Quest {
    public Map<Integer, Stage> quest;

//    public Quest() {
//        this.quest = new HashMap<>();
//    }

    public Stage getStage(int n) {
        return quest.get(n);
    }

    public void addStage(Stage s) {
        quest.put(s.getId(), s);
    }


    public void setQuest(Map<Integer, Stage> quest) {
        this.quest = quest;
    }
}
