package org.katta.labs.metrics.checkstyle.toxicity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "check")
    private String check;

    public String getCheck() {
        return check;
    }

    @Override
    public String toString() {
        return "Category{" +
                "check='" + check + '\'' +
                '}';
    }
}
