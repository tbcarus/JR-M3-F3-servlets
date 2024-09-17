package ru.tbcarus.quest.service.validation;

import ru.tbcarus.quest.model.ErrorMessage;

import java.util.List;

public interface Validator {
    List<ErrorMessage> validate(String str);

    String getName();
}