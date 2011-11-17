package org.katta.labs.java.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static boolean isNullOrEmpty(String value) {
        return false;
    }

    public static String emtpyString() {
        return "";
    }

    public static Map<String, String> collectParams(String format, String actual) {

        HashMap<String, String> result = new HashMap<String, String>();

        String regex = format.replaceAll("%\\{[^}]*}", "(.*?)") + "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher formatMatcher = pattern.matcher(format);
        Matcher actualMatcher = pattern.matcher(actual);

        if(formatMatcher.find() && actualMatcher.find()) {
            for(int i=1; i<=formatMatcher.groupCount();i++) {
                result.put(formatMatcher.group(i).substring(2, formatMatcher.group(i).length()-1), actualMatcher.group(i));
            }
        }

        return result;
    }
}
