package org.katta.labs.java.utils;

import com.google.common.base.Joiner;

import java.net.URL;

public class Scratchpad {

    public static void main(String... args) {
        System.out.println("this is a scratch pad.");

        URL location = ClassUtil.jarLocationFor(Joiner.class);
        System.out.println(location);
    }
}
