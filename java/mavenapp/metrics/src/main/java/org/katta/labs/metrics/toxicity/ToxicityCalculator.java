package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.domain.Checkstyle;
import org.katta.labs.metrics.toxicity.domain.Toxicity;
import org.katta.labs.metrics.toxicity.util.JAXBUtil;

import java.util.Map;

public class ToxicityCalculator {

    public void calculate(String checkstyleFilePath, String toxicityFilePath) {
        Checkstyle checkstyle = loadCheckstyle(checkstyleFilePath);
        Toxicity toxicity = loadToxicity(toxicityFilePath);

        Map<String, Map<String, Double>> value = checkstyle.getFiles().toxicValue();

        System.out.println(value);
    }

    private Checkstyle loadCheckstyle(String filePath) {
        return  JAXBUtil.load(Checkstyle.class, filePath);
    }

    private Toxicity loadToxicity(String toxicityFilePath) {
        return  JAXBUtil.load(Toxicity.class, toxicityFilePath);
    }
}
