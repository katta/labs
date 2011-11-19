package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.Map;

public class MethodLengthCheck extends Check {

    private final String ERROR_FORMAT = "Method length is %{actual} lines (max allowed is %{limit}).";

    @Override
    public double toxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = errorsOfThisType(file);

        double value = 0.0;

        for (CheckstyleError error : errors) {
            Map<String, String> linesMap = StringUtil.collectParams(ERROR_FORMAT, error.getMessage());
            value += new Double(linesMap.get("actual")) / new Double(linesMap.get("limit"));
        }

        return value;
    }
}
