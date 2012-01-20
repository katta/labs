package org.katta.labs.java.utils.annotation;

class RootObject {

    @AttributeConfig(name = "C1")
    private int config1;
    @AttributeConfig(name = "C2")
    private String config2;

    private CustomObject customObject;


    public int getConfig1() {
        return config1;
    }

    public void setConfig1(int config1) {
        this.config1 = config1;
    }

    public String getConfig2() {
        return config2;
    }

    public void setConfig2(String config2) {
        this.config2 = config2;
    }

    public CustomObject getCustomObject() {
        return customObject;
    }

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }
}

