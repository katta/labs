package org.katta.labs.java.utils;

import java.net.URL;
import java.security.ProtectionDomain;

public class ClassUtil {
    static URL jarLocationFor(Class clazz) {
        ProtectionDomain protectionDomain = clazz.getProtectionDomain();
        return protectionDomain.getCodeSource().getLocation();
    }
}
