package ru.tbcarus.quest.dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.config.Configs;
import ru.tbcarus.quest.model.Quest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
public class QuestDao {

    private final ObjectMapper objectMapper;
    Map<String, String> questMap = Configs.getConfigs().getQuestMapConfig().getQuestMap();

    public Quest getQuest(String questName) {
        Quest quest = null;
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            quest = objectMapper.readValue(new File(questMap.get(questName)), Quest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quest;
    }
}