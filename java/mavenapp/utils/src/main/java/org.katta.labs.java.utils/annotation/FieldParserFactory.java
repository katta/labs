package org.katta.labs.java.utils.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldParserFactory {

    private static List<FieldParser> fieldParsers = new ArrayList<FieldParser>() {{
        add(new SimpleFieldParser());
    }};

    public static FieldParser fieldParser(Field field) {
        for (FieldParser fieldParser : fieldParsers) {
            if (fieldParser.canParse(field)) {
                return fieldParser;
            }
        }
        return new NoOpFieldParser();
    }
}
