package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.check.Check;
import org.katta.labs.metrics.toxicity.check.Checks;
import org.katta.labs.metrics.toxicity.domain.Checkstyle;
import org.katta.labs.metrics.toxicity.domain.Toxicity;
import org.katta.labs.metrics.toxicity.util.JAXBUtil;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToxicityCalculator {

    public void calculate(String checkstyleFilePath) {
        Checkstyle checkstyle = loadCheckstyle(checkstyleFilePath);
        Map<String, Map<String, Double>> value = checkstyle.getFiles().toxicValue();
        System.out.println(toCsv(value));

    }

    private String toCsv(Map<String, Map<String, Double>> toxicValues) {

        StringBuilder csv = new StringBuilder();

        Checks checks = Checks.all();
        csv.append("FileName, " + checks.toCSV() + "\n");

        for (String file : toxicValues.keySet()) {
            List<String> values = new ArrayList<String>();
            values.add(file);

            for (Check check : checks) {
                values.add(toxicValues.get(file).get(check.getName()).toString());
            }
            csv.append(StringUtil.join(",", values) + "\n");
        }
        return csv.toString();

    }

    private Checkstyle loadCheckstyle(String filePath) {
        return JAXBUtil.load(Checkstyle.class, filePath);
    }

    private Toxicity loadToxicity(String toxicityFilePath) {
        return JAXBUtil.load(Toxicity.class, toxicityFilePath);
    }
}
