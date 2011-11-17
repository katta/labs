package org.katta.labs.metrics.checkstyle.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "checkstyle")
public class Checkstyle {

    @XmlElement(name = "file")
    protected List<CheckstyleFile> checkstyleFiles;

    @XmlAttribute
    protected String version;

    public List<CheckstyleFile> getFiles() {
        if (checkstyleFiles == null) {
            checkstyleFiles = new ArrayList<CheckstyleFile>();
        }
        return this.checkstyleFiles;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public List<Error> findErrorsOfType(String check) {
        ArrayList<Error> errors = new ArrayList<Error>();

        for (CheckstyleFile file : checkstyleFiles) {
            errors.addAll(file.getErrorsOfType(check));
        }
        return errors;
    }
}
