package org.katta.labs.java.validation;

public class ValidationError {
    private String errorMessage;

    public ValidationError(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
