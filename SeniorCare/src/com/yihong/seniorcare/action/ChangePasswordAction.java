package com.yihong.seniorcare.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yihong.seniorcare.common.YHException;
import com.yihong.seniorcare.common.LogHandle;
import com.yihong.seniorcare.actionforms.ChangePasswordActionForm;
import com.yihong.seniorcare.web.helper.WebActionHandler;

public class ChangePasswordAction extends BaseAction {
	private static LogHandle logHandle = new LogHandle(ChangePasswordAction.class);
	private static Logger log = logHandle.getLogHandle(ChangePasswordAction.class);
		
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String logMsg = "in " + Thread.currentThread().getStackTrace()[2].getMethodName();
			log.debug(logMsg);
			
			ChangePasswordActionForm myForm = (ChangePasswordActionForm) form;

			if (myForm.getOk() != null && myForm.getOk() != "") {
				logMsg = "OK button clicked";
				log.info(logMsg);
				
				return changePwd(mapping, form, request, response);
			} else if (myForm.getCancel() != null && myForm.getCancel() != "") {
				logMsg = "Cancel button clicked";
				log.info(logMsg);
				
				return WebActionHandler.disconnectSession(mapping, request);
			} else {
				logMsg = "screen loaded, no button clicked";
				log.info(logMsg);
				
				return (mapping.findForward("failure"));
			}
		} catch (Exception ex) {
			String logMsg = ex.getMessage();
			log.error(logMsg);

			ActionMessages messages = new ActionMessages();
			saveErrors(request, messages);
			return (mapping.findForward("failure"));
		}
	}

	@SuppressWarnings("deprecation")
	public ActionForward changePwd(ActionMapping mapping, 
									ActionForm form,
									HttpServletRequest request, 
									HttpServletResponse response) {
		
		String logMsg = "in " + Thread.currentThread().getStackTrace()[2].getMethodName();
		log.debug(logMsg);

		ChangePasswordActionForm changePass = (ChangePasswordActionForm) form;
		
		HttpSession session = request.getSession();
		String userId = (String) request.getSession().getAttribute("userId");

		java.util.Locale locale = request.getLocale();
		setLocale(request, locale);
		session.setAttribute("locale", locale);
		
		boolean isReverse = true;
		boolean hasAlpha = false;
		boolean hasNonAlpha = false;
		boolean isCircularShift = false;
		String tmpString;
		userId = changePass.getUserName();
		String oldPassword = changePass.getOldPassword().trim();
		String newPassword = changePass.getNewPassword().trim();
		String confirmPassword = changePass.getConfirmPassword().trim();
		int oldPasswordLen = oldPassword.length();
		int newPasswordLen = newPassword.length();
		int numDiffPosition;
		//boolean validChange = false;

		ActionMessages messages = new ActionMessages();
		ActionErrors errors = new ActionErrors();

		// Check if fields is empty
		if ((userId.length() == 0) || (oldPassword.length() == 0) ||
				(newPassword.length() == 0) || (confirmPassword.length() == 0)) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.blank"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// Check if the old password & new password
		if (!newPassword.equals(confirmPassword)) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.notEqual"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if the new password between 6&12 charchters
		if (newPasswordLen < 6 || newPasswordLen > 8) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.invalidLength"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if new password has alpha
		for (int i = 0; i < newPasswordLen; i++) {
			if (Character.isLetter(newPassword.charAt(i))) {
				hasAlpha = true;
			} else {
				hasNonAlpha = true;
			}
		}

		if (!hasAlpha) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.noAlphabetic"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		if (!hasNonAlpha) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.noNumeric"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if new password = old password
		if (newPassword.equals(userId)) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.equalLoginId"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if reversal
		if (newPasswordLen == userId.length()) {
			for (int i = 0; i < newPasswordLen / 2 && isReverse; i++) {
				if (newPassword.charAt(i) != userId.charAt(newPasswordLen - i - 1)) {
					isReverse = false;
				}
			}
		} else {
			isReverse = false;
		}
		
		if (isReverse) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.reverseLoginId"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if circularShift
		if (newPasswordLen == userId.length()) {
			for (int i = 1; i < newPasswordLen && !isCircularShift; i++) {
				tmpString = newPassword.substring(i, newPasswordLen) + newPassword.substring(0, i);
				if (tmpString.equals(userId)) {
					isCircularShift = true;
				}
			}
		} else {
			isCircularShift = false;
		}
		
		if (isCircularShift) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.circularLoginId"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		// check if DiffPosition
		numDiffPosition = Math.abs(oldPasswordLen - newPasswordLen);
		for (int i = 0; i < Math.min(oldPasswordLen, newPasswordLen); i++) {
			if (oldPassword.charAt(i) != newPassword.charAt(i)) {
				numDiffPosition++;
			}
		}
		
		if (numDiffPosition < 3) {

			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.password.noDifference"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}

		if (!newPassword.equals(confirmPassword)) {
			
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.notEqual"));

			saveErrors(request, errors);
			
			return (mapping.findForward("failure"));
		}
		
		// all checks are performed.
		// let's send it to backend

		logMsg = "validChage";
		log.info(logMsg);
		try {
			
			logMsg = "before calling changeUserPassword()";
			log.debug(logMsg);
			
			//String sessionId = (String) request.getSession().getAttribute("sessionId");
			return (mapping.findForward("success"));
			/*
		    validChange = ServerInterfaceWrapper.getServerInterface().changeUserPassword(sessionId, userId, oldPassword, newPassword);

			if (validChange) {
				logMsg = "Password changed successfully";
				log.info(logMsg);
				
				return (mapping.findForward("success"));
			} else {
				logMsg = "Password change not accepted";
				log.info(logMsg);
				
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.changePassword.changeFailed"));
				
		        saveErrors(request, errors);

		        return (mapping.findForward("failure"));
			}
			*/
		} catch (java.lang.Throwable ex) {

			if (ex instanceof YHException) {
				logMsg = "ChangePsswordAction.execute: Error:" + ex.getMessage();
				log.error(logMsg);
				YHException nex = (YHException) ex;

				changePass.setNewPassword("");
				changePass.setOldPassword("");
				changePass.setConfirmPassword("");

				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", nex.getErrorMsg(locale)));
				
				saveErrors(request, messages);

				return (mapping.findForward("failure"));
			} else {
				changePass.setNewPassword("");
				changePass.setOldPassword("");
				changePass.setConfirmPassword("");

				YHException nex = new YHException("NPC0001", ex.getMessage().trim(), false);
				
				logMsg = "ChangePasswordAction.execute: unexpected error: " + ex.getMessage().trim();
				log.error(logMsg);
				
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", nex.getErrorMsg(locale)));
				
				saveMessages(request, messages);
				
				return (mapping.findForward("failure"));
			}
		}
		
	}
}
