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
public class Configs {

    private static Configs configs;
    private QuestMapConfig questMapConfig;

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
}
