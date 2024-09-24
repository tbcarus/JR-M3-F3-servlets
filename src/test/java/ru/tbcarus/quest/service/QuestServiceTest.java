package ru.tbcarus.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tbcarus.quest.config.Configs;
import ru.tbcarus.quest.dao.QuestDao;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.util.Constants;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuestServiceTest {

    @Test
    void cheatCheck() {
        QuestService questService = new QuestService(new QuestDao(new ObjectMapper(new YAMLFactory())));
        String questName = Configs.getConfigs().getQuestMapConfig().getQuestNameList().get(0);
        Quest quest = questService.getQuest(questName);
        assertTrue(questService.cheatCheck(0, 1, quest));
        assertFalse(questService.cheatCheck(0, -1, quest));
    }
}