package ru.tbcarus.quest.service;

import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.dao.QuestDao;
import ru.tbcarus.quest.model.Quest;

@RequiredArgsConstructor
public class QuestService {

    private final QuestDao questDao;

    public Quest getQuest(String questName) {
        return questDao.getQuest(questName);
    }
}