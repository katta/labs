package org.katta.labs.metrics.toxicity;

import org.junit.Test;

public class ToxicityCalculatorTest {

    @Test
    public void shouldLoadCheckstyleXml() {

        ToxicityCalculator loader = new ToxicityCalculator();
        String checkstyleFilePath = this.getClass().getClassLoader().getResource("checkstyle.xml").getPath();

        loader.calculate(checkstyleFilePath);
    }
}
