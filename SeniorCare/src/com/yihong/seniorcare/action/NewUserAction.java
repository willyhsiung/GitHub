package com.yihong.seniorcare.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yihong.seniorcare.common.LogHandle;

public class NewUserAction extends BaseAction {
	@SuppressWarnings("unused")

	private static LogHandle logHandle = new LogHandle(NewUserAction.class);
	private static Logger log = logHandle.getLogHandle(NewUserAction.class);
		
	//@SuppressWarnings("static-access")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
				return null;
/*
		try {
			 *
			NewUserActionForm myForm = (NewUserActionForm) form;
			
			WebActionHandler.verifySession(request, "NewUser");

			String userId = "";
			String sessionId = null;
			Locale locale = null;
			HttpSession session = request.getSession();
			if (session != null) {
				locale = (Locale) session.getAttribute("locale");
				sessionId = (String) session.getAttribute("sessionId");
				userId = (String) request.getSession().getAttribute("userId");
			}

			request.setAttribute("valuesList.participantIds", StaticLists.getParticipantIds(sessionId, locale, true, true));

			request.setAttribute("valuesList.groupIds", StaticLists.getGroupIds(myForm.getParticipantId(), sessionId, locale, true));

			boolean saveClicked = myForm.getSave() != null && !myForm.getSave().equals("");

			if (saveClicked) {
				myForm.setSave("");

				com.yihong.seniorcare.common.YHException npcEx = new com.yihong.seniorcare.common.YHException("NPC4090E");
				boolean emptyFields = false;

				if (myForm.getParticipantId().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4062E"));
					emptyFields = true;
				}
				
				if (myForm.getUserId().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4072E"));
					emptyFields = true;
				}

				if (myForm.getUserName().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4073E"));
					emptyFields = true;
				}

				if (myForm.getPassword().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4085E"));
					emptyFields = true;
				}

				if (myForm.getConfirmPassword().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4086E"));
					emptyFields = true;
				}

				if (myForm.getPermissionGroup().equalsIgnoreCase("")) {
					npcEx.addExceptionInList(new YHException("NPC4079E"));
					emptyFields = true;
				}

				if (emptyFields) {
					throw npcEx;
				}
				else {
					String chkPassMsg = "";
					chkPassMsg = checkPassword(myForm.getPassword(), myForm.getConfirmPassword(), myForm.getUserId());
					if (!chkPassMsg.equalsIgnoreCase("all checks are performed")) {
						ActionMessages messages = new ActionMessages();
						messages.add(messages.GLOBAL_MESSAGE,new ActionMessage(chkPassMsg));
						saveErrors(request, messages);
						return (mapping.findForward("failure"));
					}
					else {
						String maxUsers = ProductProperties.getProperty("MaxLimit");
						YHException nex = new YHException("NPC4093E");	
						int noOfUsers = 0;
								
						noOfUsers = ServerInterfaceWrapper.getServerInterface().getNoOfParticipantUsers(locale, myForm.getParticipantId());
						
						boolean passAllUsers = true;
						if(maxUsers != null && noOfUsers >= Integer.parseInt(maxUsers))
							passAllUsers=false;
								
						if(!passAllUsers) {
							throw nex;
						}
						else {
							myForm.setPassword(myForm.getPassword());
	
							NPCMCHUser newUser = new NPCMCHUser();
	
							newUser.setParticipantId(myForm.getParticipantId());
							newUser.setUserId(myForm.getUserId());
							newUser.setUserName(myForm.getUserName());
							newUser.setPassword(myForm.getPassword());
							newUser.setPhone(myForm.getPhone());
							newUser.setEmail(myForm.getEmail());
							newUser.setPermissionGroup(myForm.getPermissionGroup());
							newUser.setUpdate_time(DBMgrBase.getCurrentTime());
							newUser.setUpdated_by(userId);
	
							ServerInterfaceWrapper.getServerInterface().createNewMCHUser(newUser);
							
							ActionMessages messages = new ActionMessages();
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("admin.msg.changes.successfull"));
							saveMessages(request, messages);
							return mapping.findForward("failure");
						}
					}
				}
			}
			return mapping.findForward("failure");
		} catch (Exception ex) {
			return saveErrors(mapping, form, request, ex);
		}
		*/
	}

	private String checkPassword(String newPassword, String confirmPassword, String userId) {

		boolean isReverse = true;
		boolean hasAlpha = false;
		boolean hasNonAlpha = false;
		boolean isCircularShift = false;
		String tmpString;
		int newPasswordLen = newPassword.length();

		// Check if the old password & new password
		if (!newPassword.equals(confirmPassword)) {
			return ("error.PassConfPass.notEqual");
		}

		// check if the new password between 6&8 charchters
		if (newPasswordLen < 6 || newPasswordLen > 15) {
			return ("error.changePassword.password.invalidLength");
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
			return ("error.changePassword.password.noAlphabetic");
		}

		if (!hasNonAlpha) {
			return ("error.changePassword.password.noNumeric");
		}

		// check if new password = userId
		if (newPassword.equals(userId)) {
			return ("error.changePassword.password.equalLoginId");
		}

		// check if reversal
		if (newPasswordLen == userId.length()) {
			for (int i = 0; i < newPasswordLen / 2 && isReverse; i++) {
				if (newPassword.charAt(i) != userId.charAt(newPasswordLen - i
						- 1)) {
					isReverse = false;
				}
			}
		}
		else {
			isReverse = false;
		}
		
		if (isReverse) {
			return ("error.changePassword.password.reverseLoginId");
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
			return ("error.changePassword.password.circularLoginId");
		}
		return "all checks are performed";
	}
}
