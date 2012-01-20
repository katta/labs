package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;

class SimpleFieldParser extends FieldParser {

    @Override
    public boolean canParse(Field field) {
        return field.isAnnotationPresent(AttributeConfig.class);
    }

    @Override
    public Attributes doParse(Field field, Object object) throws IllegalAccessException {

        Attributes attributes = new Attributes();
        attributes.add(new Attribute(field.getAnnotation(AttributeConfig.class).name(), String.valueOf(field.get(object))));
        return attributes;
    }
}
