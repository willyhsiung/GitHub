package com.yihong.seniorcare.actionforms;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.list.LazyList;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class UserListActionForm extends ListActionForm {
	@SuppressWarnings("unused")
	

    private String participantId;
    private String userId;
 /*   
    private List<NPCMCHUser> userList;
    
    private String delete;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void reset(ActionMapping mapping,HttpServletRequest request) {
    	super.reset(mapping, request);
        participantId = "";
        userId = "";
        try {
            Factory factory = new Factory() {
                public Object create() {
                    return new com.telcordia.inpac.intf.admin.NPCMCHUser();
                }
            };
            userList = LazyList.decorate(new ArrayList(), factory);
        } catch (Exception ex) {}
    }

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<NPCMCHUser> getUserList() {
		return userList;
	}

	public void setUserList(List<NPCMCHUser> userList) {
		this.userList = userList;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDelete() {
		return delete;
	}
	*/
}
