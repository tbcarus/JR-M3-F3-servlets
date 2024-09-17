package ru.tbcarus.quest.service.validation;

import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.model.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class LoginValidationExecutor {
    private final List<Validator> validators;

    public List<ErrorMessage> validate(Map<String, String> data) {
        List<ErrorMessage> errors = new ArrayList<>();
        for (Validator validator : validators) {
            errors.addAll(validator.validate(data.get(validator.getName())));
        }
        return errors;
    }
}