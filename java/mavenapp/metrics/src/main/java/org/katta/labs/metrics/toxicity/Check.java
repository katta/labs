package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

public abstract class Check {

    public abstract double toxicValue(CheckstyleFile file);

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
