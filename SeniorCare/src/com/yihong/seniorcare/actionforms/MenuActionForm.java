package com.yihong.seniorcare.actionforms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class MenuActionForm extends ActionForm {
    private String menu;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void reset(ActionMapping actionMapping, HttpServletRequest servletRequest) {
        menu="";
    }
}
