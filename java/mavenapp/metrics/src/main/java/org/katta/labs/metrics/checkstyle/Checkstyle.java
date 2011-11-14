package org.katta.labs.metrics.checkstyle;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "checkstyle")
public class Checkstyle {

    @XmlElement(name = "file")
    protected List<File> files;

    @XmlAttribute
    protected String version;

    public List<File> getFiles() {
        if (files == null) {
            files = new ArrayList<File>();
        }
        return this.files;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
