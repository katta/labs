package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;

class NoOpFieldParser extends FieldParser {

    @Override
    public boolean canParse(Field field) {
        return true;
    }

    @Override
    public Attributes doParse(Field field, Object object) throws IllegalAccessException {
        return new Attributes();
    }
}
