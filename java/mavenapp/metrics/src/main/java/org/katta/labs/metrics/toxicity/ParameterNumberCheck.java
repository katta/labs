package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public class ParameterNumberCheck extends Check {

    @Override
    public double toxicValue(CheckstyleFile file) {
        CheckstyleErrors errors = file.errorsOfType(this.getClass().getSimpleName());
        return errors.size();
    }

}
