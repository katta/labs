package org.katta.labs.java.utils;

import org.junit.Test;

import java.util.Map;

public class StringUtilTest {

    @Test
    public void shouldCollectParams() {

        Map<String, String> params = StringUtil.collectParams("this is %{name} and %{address}.", "this is katta and 25th block. and some random junk");

        System.out.println(params);


    }
}
