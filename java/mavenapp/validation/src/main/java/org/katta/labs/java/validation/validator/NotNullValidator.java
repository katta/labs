package org.katta.labs.java.validation.validator;

import org.katta.labs.java.validation.ValidationErrors;
import org.katta.labs.java.validation.Validator;

public class NotNullValidator implements Validator<Object> {
    public ValidationErrors validate(Object object) {

        ValidationErrors errors = new ValidationErrors();
        if(object == null) {
            errors.add("Object is null");
        }
        return errors;
    }
}
