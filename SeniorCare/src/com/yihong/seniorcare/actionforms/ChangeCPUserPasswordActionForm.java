package com.yihong.seniorcare.actionforms;

import org.apache.struts.action.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ChangeCPUserPasswordActionForm extends ActionForm {
	@SuppressWarnings("unused")
	
	
	private String userName;
	private String newPassword;
	private String confirmPassword;
	
	private String ok;
	private String clear;

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
		userName = "";
		newPassword = "";
		confirmPassword = "";
		ok = "";
		clear = "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
}
