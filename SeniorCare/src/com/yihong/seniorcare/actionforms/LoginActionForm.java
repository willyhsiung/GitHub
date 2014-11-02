package com.yihong.seniorcare.actionforms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class LoginActionForm extends ActionForm {
	@SuppressWarnings("unused")
	
	private String userName;
	private String submit;
	private String changePassword;
	private String password;
	private String systemTime;
	private String focusControl;

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		userName = null;
		submit = null;;
		password = null;
		changePassword = null;
		systemTime = null;
		focusControl = null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getSubmit() {
		return submit;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}

	public String getFocusControl() {
		return focusControl;
	}

	public void setFocusControl(String focusControl) {
		this.focusControl = focusControl;
	}
}