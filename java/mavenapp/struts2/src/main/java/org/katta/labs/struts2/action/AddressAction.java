package org.katta.labs.struts2.action;

import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {

    private String firstName;
    private String lastName;


    public String show() throws InterruptedException {
        return "show_address_form";
    }

    public void validateSave() {

        if(Strings.isNullOrEmpty(getFirstName())) {
            addFieldError("firstName", "First name is mandatory.");
        }

        if(Strings.isNullOrEmpty(getLastName())) {
            addFieldError("lastName", "Last name is mandatory.");
        }
    }

    public String save() {
        addActionMessage("Successfully saved!!");
        return SUCCESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
