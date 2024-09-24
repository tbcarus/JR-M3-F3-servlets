package ru.tbcarus.quest.service;

import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.dao.QuestDao;
import ru.tbcarus.quest.model.Phase;
import ru.tbcarus.quest.model.Quest;
import ru.tbcarus.quest.model.Stage;

@RequiredArgsConstructor
public class QuestService {

    private final QuestDao questDao;

    public Quest getQuest(String questName) {
        return questDao.getQuest(questName);
    }

    public boolean cheatCheck(int currentStageId, int nextStageId, Quest quest) {
        Stage currentStage = quest.getStage(currentStageId);
        return (currentStageId == nextStageId && currentStageId == 0)
                || currentStage.getToChildrenStages().containsKey(nextStageId)
                || currentStageId == nextStageId
                || nextStageId == 0 && (currentStage.getPhase() == Phase.LOSE || currentStage.getPhase() == Phase.WIN);
    }
}