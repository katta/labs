package org.katta.labs.java.validation;

import java.util.ArrayList;

public class ValidationErrors extends ArrayList<ValidationError> {

    public void add(String errorMessage) {
        super.add(new ValidationError(errorMessage));
    }

    public ValidationError first() {
        if (size() > 0) {
            return get(0);
        }
        return null;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
