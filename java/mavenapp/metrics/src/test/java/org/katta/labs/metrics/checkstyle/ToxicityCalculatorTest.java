package org.katta.labs.metrics.checkstyle;

import org.junit.Test;

public class ToxicityCalculatorTest {

    @Test
    public void shouldLoadCheckstyleXml() {

        ToxicityCalculator loader = new ToxicityCalculator();
        String checkstyleFilePath = this.getClass().getClassLoader().getResource("checkstyle.xml").getPath();
        String toxicityFilePath = this.getClass().getClassLoader().getResource("toxicity.xml").getPath();

        loader.calculate(checkstyleFilePath, toxicityFilePath);
    }
}
