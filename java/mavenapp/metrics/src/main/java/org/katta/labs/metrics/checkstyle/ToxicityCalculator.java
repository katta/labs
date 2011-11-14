package org.katta.labs.metrics.checkstyle;

import org.katta.labs.metrics.checkstyle.toxicity.Category;
import org.katta.labs.metrics.checkstyle.toxicity.Toxicity;
import org.katta.labs.metrics.checkstyle.util.JAXBUtil;

import java.util.List;

public class ToxicityCalculator {

    public void calculate(String checkstyleFilePath, String toxicityFilePath) {
        Checkstyle checkstyle = loadCheckstyle(checkstyleFilePath);
        Toxicity toxicity = loadToxicity(toxicityFilePath);

        for (Category category : toxicity.getCategories()) {
            List<Error> errors = checkstyle.findErrorsOfType(category.getCheck());
            System.out.println("Category :" + category);
            System.out.println("Errors Size :" + errors.size());
            System.out.println(errors);
        }
    }

    private Checkstyle loadCheckstyle(String filePath) {
        return  JAXBUtil.load(Checkstyle.class, filePath);
    }

    private Toxicity loadToxicity(String toxicityFilePath) {
        return  JAXBUtil.load(Toxicity.class, toxicityFilePath);
    }
}
