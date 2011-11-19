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
        Map<String, Map<String, Double>> value = checkstyle.getFiles(). calculateToxicValue();

        System.out.println(summary(value));
        System.out.println(toCsv(value));

    }

    private String summary(Map<String, Map<String, Double>> toxicValues) {
        Checks allChecks = Checks.all();
        for (Map<String, Double> values : toxicValues.values()) {
            for (String checkName : values.keySet()) {
                allChecks.find(checkName).addToxicValue(values.get(checkName));
            }
        }

        return allChecks.toString();
    }

    private String toCsv(Map<String, Map<String, Double>> toxicValues) {

        StringBuilder csv = new StringBuilder();

        Checks checks = Checks.all();
        csv.append("FileName,").append(checks.toCSV()).append("\n");

        for (String file : toxicValues.keySet()) {
            List<String> values = new ArrayList<String>();
            values.add(file);

            for (Check check : checks) {
                values.add(toxicValues.get(file).get(check.getName()).toString());
            }
            csv.append(StringUtil.join(",", values)).append("\n");
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
