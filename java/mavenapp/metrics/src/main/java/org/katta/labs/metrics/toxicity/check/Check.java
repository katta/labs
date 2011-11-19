package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleError;
import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.Map;

public abstract class Check {

    public double toxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = errorsOfThisType(file);

        double value = 0.0;

        for (CheckstyleError error : errors) {
            Map<String, String> linesMap = StringUtil.collectParams(getErrorFormat(), error.getMessage());
            value += new Double(linesMap.get("actual")) / new Double(linesMap.get("limit"));
        }

        return value;
    }

    protected abstract String getErrorFormat();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    protected CheckstyleErrors errorsOfThisType(CheckstyleFile file) {
        return file.errorsOfType(this.getClass().getSimpleName());
    }
}
