package org.katta.labs.metrics.toxicity;

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
        toCsv(value);

    }

    private void toCsv(Map<String, Map<String, Double>> toxicValues) {

        Checks checks = Checks.all();
        System.out.println("FileName, " + checks.toCSV());

        for (String file : toxicValues.keySet()) {
            List<String> values = new ArrayList<String>();
            values.add(file);

            for (Check check : checks) {
                values.add(toxicValues.get(file).get(check.getName()).toString());
            }
            System.out.println(StringUtil.join(",", values));
        }

    }

    private Checkstyle loadCheckstyle(String filePath) {
        return  JAXBUtil.load(Checkstyle.class, filePath);
    }

    private Toxicity loadToxicity(String toxicityFilePath) {
        return  JAXBUtil.load(Toxicity.class, toxicityFilePath);
    }
}
