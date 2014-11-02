package com.yihong.seniorcare.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yihong.seniorcare.actionforms.UserListActionForm;
import com.yihong.seniorcare.common.LogHandle;
import com.yihong.seniorcare.web.helper.PagingMgr;
import com.yihong.seniorcare.web.helper.WebActionHandler;

public class UserListAction extends BaseAction {
	@SuppressWarnings("unused")

	private static LogHandle logHandle = new LogHandle(UserListAction.class);
	private static Logger log = logHandle.getLogHandle(UserListAction.class);
		
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
				return null;
		/*
		try {
			UserListActionForm myForm = (UserListActionForm) form;
			
			WebActionHandler.verifySession(request, "UserList");

			Locale locale = null;
			String sessionId = null;
			HttpSession session = request.getSession();
			if (session != null) {
				locale = (Locale) session.getAttribute("locale");
				sessionId = (String) session.getAttribute("sessionId");
			}
 		
			List<NPCMCHUser> userResList = new ArrayList<NPCMCHUser>();
			List<NPCAdminObj> userObj = new ArrayList<NPCAdminObj>();

			request.setAttribute("valuesList.participantIds", StaticLists.getParticipantIds(sessionId, locale, true, true));
			
			request.setAttribute("valuesList.userIds", StaticLists.getUserIds(sessionId, locale, true));
			
			boolean retrieveClicked = myForm.getRetrieve() != null && !myForm.getRetrieve().equals("");
			boolean clearClicked = myForm.getClear() != null && !myForm.getClear().equals("");
			boolean addClicked = myForm.getAdd() != null && !myForm.getAdd().equals("");
			boolean deleteClicked = myForm.getDeleteUsers() != null && !myForm.getDeleteUsers().equals("");
				
			if (addClicked) {
				myForm.setAdd("");
				return mapping.findForward("newUser");
			}
			else if (clearClicked) {
				myForm.setClear("");
				myForm.setParticipantId("");
				myForm.setUserId("");
				userObj = new ArrayList<NPCAdminObj>();
				userResList = new ArrayList<NPCMCHUser>();
				myForm.setPageNumber("");
				myForm.setRecordFrom("0");
				myForm.setRecordTo("0");
				myForm.setNumberofRecords("0");
				userResList.clear();
				myForm.setUserList(userResList);
				myForm.setPagesList(userResList);
			}
			else if (retrieveClicked) {
				myForm.setRetrieve("");
				myForm.setIsNewQuery("true");
				myForm.setPageNumber("1");
				retrieveList(myForm);
			}
			else if (deleteClicked) {
				myForm.setDeleteUsers("");
					
				userResList = myForm.getUserList();
				for (NPCMCHUser npcUser : userResList) {
					if (npcUser.getRemoveFlag() != null && !npcUser.getRemoveFlag().equals(""))
						userObj.add((NPCAdminObj) npcUser);
				}

				if (userObj.size() == 0) {
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("admin.msg.user.delete.notSelect"));
					saveMessages(request, messages);
				}
				else {
					ServerInterfaceWrapper.getServerInterface().deleteNPCAdminList(userObj);
					
					myForm.setIsNewQuery("true");
					myForm.setPageNumber("1");
					retrieveList(myForm);
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("admin.msg.user.delete.successfull"));
					saveMessages(request, messages);
				}
			}
			else if (myForm.getPageNumber() != null && !myForm.getPageNumber().equals("")) {
				retrieveList(myForm);
			}
			else {
				myForm.setParticipantId("");
				myForm.setUserId("");
				myForm.setPageNumber("1");
				myForm.setIsNewQuery("true");
				retrieveList(myForm);
			}
			return mapping.findForward("failure");
		} catch (Exception ex) {
			UserListActionForm myForm = (UserListActionForm) form;
			myForm.setPageNumber("");
			myForm.setRecordFrom("0");
			myForm.setRecordTo("0");
			myForm.setNumberofRecords("0");
			return saveErrors(mapping, form, request, ex);
		}*/
	}
	
	private void retrieveList(UserListActionForm myForm) throws Exception {
		
		try {
			boolean isNewQuery = myForm.getIsNewQuery().equals("true");

            PagingMgr paging = new PagingMgr();
            if (isNewQuery){
                paging.setNumberofRecords("-1");
            }
            paging.setPagingProperties(Integer.parseInt(myForm.getPageNumber()));
/*			
			List<NPCMCHUser> userList = new ArrayList<NPCMCHUser>();
			NPCUserSearch userSearch = new NPCUserSearch();
			
			if (myForm.getParticipantId() != null)
				userSearch.setParticipant_id(myForm.getParticipantId());
			
			if (myForm.getUserId() != null)
				userSearch.setUser_id(myForm.getUserId());

			userSearch.setRecord_from(paging.getRecordFrom());
			userSearch.setRecord_to(paging.getRecordTo());
			
			userList = ServerInterfaceWrapper.getServerInterface().getUserList(userSearch);

			myForm.setUserList(userList);
			
			if (userList == null || userList.size() == 0) {
				NPCException ex = new NPCException("NPC4094E");
				throw ex;
			}
			
			if (isNewQuery) {
                paging.setNumberofRecords(userList.get(0).getNumberofRecords());
                myForm.setNumberofRecords(paging.getNumberofRecords());
                myForm.setIsNewQuery("false");
                isNewQuery = false;
            }
			paging.setPagingProperties(Integer.parseInt(myForm.getPageNumber()));
            myForm.setRecordFrom(paging.getRecordFrom());
            myForm.setRecordTo(paging.getRecordTo());
            myForm.setPagesList(paging.getPages());
            myForm.setBotPageSelector(myForm.getPageNumber());
            myForm.setTopPageSelector(myForm.getPageNumber());
            */
		} catch (Exception ex) {
			throw ex;
		}
		 
	}
}
