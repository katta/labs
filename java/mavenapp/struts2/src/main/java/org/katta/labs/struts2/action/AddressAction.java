package org.katta.labs.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {

    public String show() throws InterruptedException {
        Thread.sleep(10000);
        return "show_address_form";
    }
}
