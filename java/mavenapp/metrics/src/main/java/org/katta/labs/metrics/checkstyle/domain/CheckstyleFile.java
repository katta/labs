package org.katta.labs.metrics.checkstyle.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleFile {

    @XmlElement(name = "error")
    protected List<Error> errors;

    @XmlAttribute
    protected String name;

    public List<Error> getErrors() {
        if (errors == null) {
            errors = new ArrayList<Error>();
        }
        return this.errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Collection<? extends Error> getErrorsOfType(String check) {
        ArrayList<Error> filteredErrors = new ArrayList<Error>();

        for (Error error : errors) {
            if(error.getSource().endsWith(check+"Check")) {
                filteredErrors.add(error);
            }
        }
        return filteredErrors;
    }
}
