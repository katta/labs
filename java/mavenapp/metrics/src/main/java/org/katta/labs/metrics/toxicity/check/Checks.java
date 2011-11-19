package org.katta.labs.metrics.toxicity.check;

import org.katta.labs.metrics.toxicity.domain.CheckstyleFile;
import org.katta.labs.metrics.toxicity.util.StringUtil;

import java.util.*;

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
        return new Checks(new ParameterNumberCheck(), new MethodLengthCheck(), new NestedIfDepthCheck());
    }

    public HashMap<String, Double> toxicValue(CheckstyleFile checkstyleFile) {
        HashMap<String, Double> checkValues = new HashMap<String, Double>();

        for (Check check : this) {
            checkValues.put(check.getName(), check.toxicValue(checkstyleFile));
        }
        return checkValues;
    }


    public List<String> names() {
        ArrayList<String> names = new ArrayList<String>();
        for (Check check : this) {
            names.add(check.getName());
        }
        return names;
    }

    public String toCSV() {
        return StringUtil.join(",", names());
    }
}
