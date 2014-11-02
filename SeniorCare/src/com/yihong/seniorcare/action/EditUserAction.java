package com.yihong.seniorcare.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yihong.seniorcare.actionforms.EditUserActionForm;
import com.yihong.seniorcare.web.helper.StaticLists;
import com.yihong.seniorcare.web.helper.WebActionHandler;

public class EditUserAction extends BaseAction {
	@SuppressWarnings("unused")

	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) {
		
		try {
			EditUserActionForm myForm = (EditUserActionForm) form;
			
			WebActionHandler.verifySession(request, "User");

			String sessionId = (String) request.getSession().getAttribute("sessionId");
			Locale locale = (Locale) request.getSession().getAttribute("locale");
			
			//request.setAttribute("valuesList.groupIds", StaticLists.getGroupIds(myForm.getParticipantId(), sessionId, locale, false));

			boolean saveClicked = myForm.getSave() != null && !myForm.getSave().equals("");
			boolean deleteClicked = myForm.getDeleteUser() != null && !myForm.getDeleteUser().equals("");
			boolean changePasswordClicked = myForm.getChangePassword() != null && !myForm.getChangePassword().equals("");
			 
			if (saveClicked) {
				myForm.setSave("");
				/*
				NPCMCHUser userDetails = new NPCMCHUser();
				userDetails.setParticipantId(myForm.getParticipantId());
				userDetails.setUserId(myForm.getUserId());
				userDetails.setUserName(myForm.getUserName());
				userDetails.setPassword(myForm.getPassword());
				userDetails.setPermissionGroup(myForm.getGroup());
				userDetails.setPhone(myForm.getPhone());
				userDetails.setEmail(myForm.getEmail());
				userDetails.setUpdated_by(request.getSession().getAttribute("userId").toString());

				try {
					ServerInterfaceWrapper.getServerInterface().editUser(sessionId, userDetails);

				} catch (NPCException e) {
					userDetails = ServerInterfaceWrapper.getServerInterface().retrieveUserDetails(myForm.getUserId(), myForm.getParticipantId());
					myForm.setUserName(userDetails.getUserName());
					myForm.setGroup(userDetails.getPermissionGroup());
					myForm.setPassword(userDetails.getPassword());
					myForm.setPhone(userDetails.getPhone());
					myForm.setEmail(userDetails.getEmail());
					throw e;
				}
				*/
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("admin.msg.changes.successfull"));
				saveMessages(request, messages);
			} 
			else if (deleteClicked) {
				/*
				myForm.setDelete("");
				try {
					ServerInterfaceWrapper.getServerInterface().deleteUser(sessionId, myForm.getUserId(), myForm.getParticipantId());
					myForm.setParticipantId("");
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("admin.msg.user.delete.successfull"));
					saveMessages(request, messages);
					return mapping.findForward("delete");
				} catch (NPCException e) {
					NPCMCHUser userDetails = ServerInterfaceWrapper.getServerInterface().retrieveUserDetails(myForm.getUserId(), myForm.getParticipantId());
					myForm.setUserName(userDetails.getUserName());
					myForm.setGroup(userDetails.getPermissionGroup());
					myForm.setPassword(userDetails.getPassword());
					myForm.setPhone(userDetails.getPhone());
					myForm.setEmail(userDetails.getEmail());
					throw e;
				}
				*/
			}
			else if (changePasswordClicked) {
				myForm.setChangePassword("");
				final ActionForward successAction = mapping.findForward("changePassword");
				if (successAction != null) {
					ActionForward modifiedSuccessAction = new ActionForward();   
					modifiedSuccessAction.setName(successAction.getName());
					modifiedSuccessAction.setPath(successAction.getPath() + "?&userName=" + myForm.getUserId() + "&oldPassword=" + myForm.getPassword());   
					modifiedSuccessAction.setRedirect(true);   
					return modifiedSuccessAction;
				}
			}
			/*
			NPCMCHUser userDetails = ServerInterfaceWrapper.getServerInterface().retrieveUserDetails(myForm.getUserId(), myForm.getParticipantId());
			myForm.setUserName(userDetails.getUserName());
			myForm.setGroup(userDetails.getPermissionGroup());
			myForm.setPassword(userDetails.getPassword());
			myForm.setPhone(userDetails.getPhone());
			myForm.setEmail(userDetails.getEmail());
			*/
			return mapping.findForward("failure");
		} catch (Exception ex) {
			return saveErrors(mapping, form, request, ex);
		}
	}
}
