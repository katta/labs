package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;
import java.util.Collection;

public class FirstElementInCollectionFieldParser extends FieldParser {
    @Override
    public boolean canParse(Field field) {
        return Collection.class.isAssignableFrom(field.getType());
    }

    @Override
    public Attributes doParse(Field field, Object object) throws IllegalAccessException {
        Collection collection = (Collection) field.get(object);
        for (Object entry : collection) {
            return new ObjectWalker().walk(entry);
        }
        return new Attributes();
    }
}
