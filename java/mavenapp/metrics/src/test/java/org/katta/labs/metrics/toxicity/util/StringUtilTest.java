package org.katta.labs.metrics.toxicity.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class StringUtilTest {

    @Test
    public void shouldCollectTokens() {

        Map<String, String> map = StringUtil.collectParams("Method length is %{actual} lines (max allowed is %{limit}).", "Method length is 6 lines (max allowed is 5).");
        Assert.assertEquals("6", map.get("actual"));
    }
}
