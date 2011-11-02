package org.katta.labs.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.katta.labs.struts2.model.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class LookupAction extends ActionSupport {
    private List<EmailAddress> emails = new ArrayList<EmailAddress>();
    private List<String> departments = new ArrayList<String>();

    public String emailAddresses() {
        addEmail("katta@bt.com");
        return SUCCESS;
    }

    public String departments() throws Exception {

        departments.add("Sales");
        departments.add("Marketing");
        departments.add("Engineering");

        return SUCCESS;
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

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
