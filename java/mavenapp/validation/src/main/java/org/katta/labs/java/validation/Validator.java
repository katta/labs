package org.katta.labs.java.validation;

public interface Validator<T> {
    ValidationErrors validate(T object);
}
