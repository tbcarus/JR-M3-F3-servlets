package ru.tbcarus.quest.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class QuestMapConfig {
    Map<String, String> questMap;

    public List<String> getQuestNameList() {
        List<String> list = new ArrayList<>(questMap.keySet());
        Collections.sort(list);
        return list;
    }
}
