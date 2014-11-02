package com.yihong.seniorcare.actionforms;

import org.apache.struts.action.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ChangePasswordActionForm extends ActionForm {
	@SuppressWarnings("unused")
	
	private String userName;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	private String ok;
	private String cancel;

	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
		userName = "";
		oldPassword = "";
		newPassword = "";
		confirmPassword = "";
		ok = "";
		cancel = "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
}
