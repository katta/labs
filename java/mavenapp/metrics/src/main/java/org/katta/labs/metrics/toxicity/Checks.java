package org.katta.labs.metrics.toxicity;

import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Checks extends ArrayList<Check> {

    public Checks() {
    }

    public Checks(int i) {
        super(i);
    }

    public Checks(Check... checks) {
        this(Arrays.asList(checks));
    }

    public Checks(Collection<? extends Check> checks) {
        super(checks);
    }

    public static Checks all() {
        return new Checks(new ParameterNumberCheck());
    }

    public HashMap<String, Double> toxicValue(CheckstyleFile checkstyleFile) {
        HashMap<String, Double> checkValues = new HashMap<String, Double>();

        for (Check check : this) {
            checkValues.put(check.getName(), check.toxicValue(checkstyleFile));
        }
        return checkValues;
    }
}
