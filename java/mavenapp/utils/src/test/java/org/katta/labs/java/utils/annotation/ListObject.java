package org.katta.labs.java.utils.annotation;

@AttributeClass
public class ListObject {
    @AttributeConfig(name = "L1")
    private String config;

    public ListObject(String config) {
        this.config = config;
    }
}
