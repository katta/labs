package org.katta.labs.java.validation.validator;

import org.katta.labs.java.validation.ValidationErrors;
import org.katta.labs.java.validation.Validator;

public class NotNullOrEmptyValidator implements Validator<String> {

    private NotNullValidator notNullValidator;

    public NotNullOrEmptyValidator() {
        notNullValidator = new NotNullValidator();
    }

    public ValidationErrors validate(String object) {
        ValidationErrors errors = notNullValidator.validate(object);
        if(errors.isNotEmpty()) return errors;

        if(object.trim().length() == 0) {
            errors.add("String is empty");
        }

        return errors;
    }
}
