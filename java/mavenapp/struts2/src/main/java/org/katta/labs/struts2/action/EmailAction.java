package org.katta.labs.struts2.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.katta.labs.struts2.model.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class EmailAction extends ActionSupport {
    private List<EmailAddress> emails = new ArrayList<EmailAddress>();
    private List<String> somejunk = new ArrayList<String>();

    public String emailAddresses() {
        addEmail("katta@bt.com");
        somejunk.add("blaaa");
        return Action.SUCCESS;
    }

    private void addEmail(String email) {
        emails.add(new EmailAddress(email));
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailAddress> emails) {
        this.emails = emails;
    }

    public List<String> getSomejunk() {
        return somejunk;
    }

    public void setSomejunk(List<String> somejunk) {
        this.somejunk = somejunk;
    }
}
