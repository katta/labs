package org.katta.labs.struts2.model;

public class EmailAddress {
    private String emailId;

    public EmailAddress(String emailId) {

        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
