package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;

public class NestedObjectFieldParser extends FieldParser {
    @Override
    public boolean canParse(Field field) {
        return field.getType().isAnnotationPresent(AttributeClass.class);

    }

    @Override
    public Attributes doParse(Field field, Object object) throws IllegalAccessException {
        return new ObjectWalker().walk(field.get(object));
    }
}
