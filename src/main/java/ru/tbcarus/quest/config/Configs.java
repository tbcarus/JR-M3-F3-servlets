package ru.tbcarus.quest.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.service.ConfigReader;
import ru.tbcarus.quest.util.Constants;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Configs {

    private static Configs configs;

    QuestMapConfig questMapConfig;
    Map<String, Quest> quests = new HashMap<>();

    private Configs() {}

    private Configs(QuestMapConfig questMapConfig) {
        this.questMapConfig = questMapConfig;
    }

    public static Configs getConfigs() {
        if (configs == null) {
            configs = new Configs(ConfigReader.readConfig(Constants.QUESTS_MAP_YAML, QuestMapConfig.class));
        }
        return configs;
    }

    public static Quest getQuest(String questName) {
        Quest quest = configs.quests.get(questName);
        if (quest == null) {
            quest = ConfigReader.readConfig(configs.questMapConfig.getQuestMap().get(questName), Quest.class);
            configs.quests.put(questName, quest);
        }
        return quest;
    }

}
