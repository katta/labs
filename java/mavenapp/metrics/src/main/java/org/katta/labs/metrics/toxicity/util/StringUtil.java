package org.katta.labs.metrics.toxicity.util;

import java.util.List;

public class StringUtil {

    public static String join(String delimiter, List<String> values){
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append(value).append(delimiter);
        }
        String joinedString = builder.toString();
        return joinedString.substring(0, joinedString.length()-1);
    }
}
