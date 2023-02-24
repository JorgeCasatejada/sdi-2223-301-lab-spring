package com.uniovi.sdi2223301spring.validators;

import com.uniovi.sdi2223301spring.entities.Mark;
import com.uniovi.sdi2223301spring.entities.Professor;
import com.uniovi.sdi2223301spring.services.MarksService;
import com.uniovi.sdi2223301spring.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddProfessorValidator  implements Validator {

    @Autowired
    private ProfessorsService professorsService;
    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "Error.empty");
        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.addProfessor.dni.length");
        }
        Character c = professor.getDni().charAt(professor.getDni().length() - 1);
        if (!Character.isAlphabetic(c)) {
            errors.rejectValue("dni", "Error.addProfessor.dni.alphabetic");
        }
        if (professorsService.getProfessor(professor.getDni()) != null) {
            errors.rejectValue("dni", "Error.addProfessor.dni.duplicate");}
    }
}

