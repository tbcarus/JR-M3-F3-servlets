package ru.tbcarus.quest.service.validation;

import ru.tbcarus.quest.model.ErrorMessage;
import ru.tbcarus.quest.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements Validator{

    public List<ErrorMessage> validate(String password) {
        List<ErrorMessage> errors = new ArrayList<>();
        if (password.length() < 3) {
            errors.add(new ErrorMessage(Constants.PASSWORD,"Password must be at least 3 characters"));
        }
        if (!password.matches("(.*[a-z])(.*[0-9].*)")) {
            errors.add(new ErrorMessage(Constants.PASSWORD,"Password must contains letters and numbers and starts with a letter"));
        }

        return errors;
    }

    @Override
    public String getName() {
        return Constants.PASSWORD;
    }
}