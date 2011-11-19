package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class ParameterNumberCheck extends Check {

    @Override
    public double toxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = errorsOfThisType(file);
        return errors.size();
    }

}
