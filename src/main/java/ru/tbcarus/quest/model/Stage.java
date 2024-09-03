package ru.tbcarus.quest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Stage {
    private Integer Id;
    private String name;
    private String description;
    private Map<Integer, String> toParentsStages;
    private Map<Integer, String> toChildrenStages;
    private Phase phase;

    public Stage(Integer Id, String name, String description, Map<Integer, String> toParentsStages, Map<Integer, String> toChildrenStages, Phase phase) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.toParentsStages = toParentsStages;
        this.toChildrenStages = toChildrenStages;
        this.phase = phase;
    }

    public void addParent(Integer parentId, String stageName) {
        toParentsStages.put(parentId, stageName);
    }

    public void addChild(Integer childId, String stageName) {
        toChildrenStages.put(childId, stageName);
    }
}
