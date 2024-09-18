package ru.tbcarus.quest.service.validation;

import lombok.RequiredArgsConstructor;
import ru.tbcarus.quest.model.ErrorMessage;
import ru.tbcarus.quest.service.UserService;
import ru.tbcarus.quest.util.Constants;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final UserService userService;

    public List<ErrorMessage> validate(String login) {
        List<ErrorMessage> errors = new ArrayList<>();
        boolean isExist = userService.isExist(login);

        if (isExist) {
            errors.add(new ErrorMessage(Constants.LOGIN, "Login already exists"));
        }
        if (login == null || login.length() < 3) {
            errors.add(new ErrorMessage(Constants.LOGIN,"Login length must be at least 3 characters"));
        }
        if (login.contains(" ")) {
            errors.add(new ErrorMessage(Constants.LOGIN,"Login must not contains spaces"));
        }
        return errors;
    }

    @Override
    public String getName() {
        return Constants.LOGIN;
    }
}