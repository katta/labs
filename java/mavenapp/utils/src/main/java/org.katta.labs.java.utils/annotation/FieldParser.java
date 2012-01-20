package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;

public abstract class FieldParser {

    public abstract boolean canParse(Field field);

    public Attributes parse(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        return doParse(field, object);
    }

    public abstract Attributes doParse(Field field, Object object) throws IllegalAccessException;
}

