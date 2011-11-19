package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class ParameterNumberCheck extends Check {

    @Override
    public double toxicValue(CheckstyleFile file) {
        return errorsOfThisType(file).size();
    }

    @Override
    protected String getErrorFormat() {
        throw new RuntimeException("This check should override parameter number check");
    }

}
