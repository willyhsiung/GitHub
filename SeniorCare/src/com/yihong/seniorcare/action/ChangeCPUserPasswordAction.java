package com.yihong.seniorcare.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.yihong.seniorcare.actionforms.ChangeCPUserPasswordActionForm;
import com.yihong.seniorcare.web.helper.WebActionHandler;

public class ChangeCPUserPasswordAction  extends BaseAction {

	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			ChangeCPUserPasswordActionForm myForm = (ChangeCPUserPasswordActionForm) form;
			
			WebActionHandler.verifySession(request, "ChangeCPUserPassword");

			String cpUuserId = "";
			String newPassword = "";
			String confirmPassword = "";
			
		//	boolean resetPassword = false;
		
			String sessionId = null;
		
			HttpSession session = request.getSession();
			if (session != null) {
				sessionId = (String) session.getAttribute("sessionId");
			}

			cpUuserId = myForm.getUserName();
			newPassword = myForm.getNewPassword();
			confirmPassword = myForm.getConfirmPassword();
			
			boolean okClicked = myForm.getOk() != null && !myForm.getOk().equals("");
			boolean clearClicked = myForm.getClear() != null && !myForm.getClear().equals("");
			
			if (okClicked) {
				myForm.setOk("");

				ActionErrors errors = validPassword(cpUuserId, newPassword, confirmPassword);
				if (errors.isEmpty()) {
					
				}
				else
					saveErrors(request, errors);
			} 
			if (clearClicked) {
				myForm.setClear("");
				myForm.setUserName("");
				myForm.setNewPassword("");
				myForm.setConfirmPassword("");
				mapping.findForward("success");
			}
			return mapping.findForward("success");
		} catch (Exception ex) {
			return saveErrors(mapping, form, request, ex);
		}
	}

	@SuppressWarnings("static-access")
	public ActionErrors validPassword(String cpUuserId,String newPassword,String confirmPassword) {
		
		ActionErrors errors = new ActionErrors();
		
		boolean hasAlpha = false;
		boolean hasNonAlpha = false;
		boolean isReverse = true;
		boolean isCircularShift = false;
		String tmpString;
		
		int newPasswordLen = newPassword.length();
		if ((newPasswordLen == 0) || (confirmPassword.length() == 0)) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.blank"));
		if (!newPassword.equals(confirmPassword)) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.notEqual"));
		if (newPasswordLen < 6 || newPasswordLen > 8) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.invalidLength"));
		
		for (int i = 0; i < newPasswordLen; i++) {
			if (Character.isLetter(newPassword.charAt(i))) {
				hasAlpha = true;
			}
			else {
				hasNonAlpha = true;
			}
		}

		if (!hasAlpha) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.noAlphabetic"));

		if (!hasNonAlpha) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.noNumeric"));
		
		if (newPassword.equals(cpUuserId)) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.equalLoginId"));
		
		if (newPasswordLen == cpUuserId.length()) {
			for (int i = 0; i < newPasswordLen / 2 && isReverse; i++) {
				if (newPassword.charAt(i) != cpUuserId.charAt(newPasswordLen - i - 1)) {
					isReverse = false;
				}
			}
		} 
		else {
			isReverse = false;
		}
		
		if (isReverse) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.reverseLoginId"));
		
		if (newPasswordLen == cpUuserId.length()) {
			for (int i = 1; i < newPasswordLen && !isCircularShift; i++) {
				tmpString = newPassword.substring(i, newPasswordLen)
						+ newPassword.substring(0, i);
				if (tmpString.equals(cpUuserId)) {
					isCircularShift = true;
				}
			}
		} else {
			isCircularShift = false;
		}
		
		if (isCircularShift) 
			errors.add(errors.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.circularLoginId"));
		
		return errors;
	}
}
