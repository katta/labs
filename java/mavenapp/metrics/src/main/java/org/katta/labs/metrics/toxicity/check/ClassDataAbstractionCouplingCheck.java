package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.Map;

public class ClassDataAbstractionCouplingCheck extends Check {

    @Override
    protected String getErrorFormat() {
        return "Class Data Abstraction Coupling is %{actual} (max allowed is %{limit})";
    }

    @Override
    public double toxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = errorsOfThisType(file);

        double value = 0.0;

        for (CheckstyleError error : errors) {
            String errorMessage = error.getMessage();
            Map<String, String> linesMap = StringUtil.collectParams(getErrorFormat(), errorMessage.substring(0, errorMessage.indexOf(")") + 1));
            value += new Double(linesMap.get("actual")) / new Double(linesMap.get("limit"));
        }

        return value;
    }
}
