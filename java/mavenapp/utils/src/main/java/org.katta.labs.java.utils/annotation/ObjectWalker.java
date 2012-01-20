package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ObjectWalker {

    public Attributes walk(Object object) throws IllegalAccessException {
        Attributes attributes = new Attributes();

        List<Field> declaredFields = getDeclaredFields(object);

        for (Field field : declaredFields) {

            attributes.addAll(FieldParserFactory.fieldParser(field).parse(field, object));

/*
            if (field.isAnnotationPresent(AttributeConfig.class)) {
                attributes.add(new Attribute(field.getAnnotation(AttributeConfig.class).name(), String.valueOf(field.get(object))));
            }
*/
        }

        return attributes;
    }

    private List<Field> getDeclaredFields(Object rootObject) {
        return Arrays.asList(rootObject.getClass().getDeclaredFields());
    }
}
