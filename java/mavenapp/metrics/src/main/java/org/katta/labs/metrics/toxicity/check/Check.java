package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleErrors;
import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public abstract class Check {

    public abstract double toxicValue(CheckstyleFile file);

    public String getName() {
        return this.getClass().getSimpleName();
    }

    protected CheckstyleErrors errorsOfThisType(CheckstyleFile file) {
        return file.errorsOfType(this.getClass().getSimpleName());
    }
}
