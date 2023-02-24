package com.uniovi.sdi2223301spring.validators;

import com.uniovi.sdi2223301spring.entities.Mark;
import com.uniovi.sdi2223301spring.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddMarkValidator implements Validator {

    @Autowired
    private MarksService marksService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Mark.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Error.empty");
        if (mark.getEmail().length() < 20) {
            errors.rejectValue("email", "Error.addMark.email.length");
        }
        if (mark.getScore() > 10 || mark.getScore() < 0) {
            errors.rejectValue("score", "Error.addMark.score.value");
        }
    }
}
