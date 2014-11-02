package com.yihong.seniorcare.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yihong.seniorcare.web.helper.WebActionHandler;

public class MainAction extends BaseAction {
	@SuppressWarnings("unused")
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			WebActionHandler.verifySession(request, "Main");
			
			String page = request.getParameter("page");
			if (page != null && !page.equals("")){
				return mapping.findForward(page);
			}
			return mapping.findForward("main");
		} catch (Exception ex) {
			return saveErrors(mapping, form, request, ex);
		}
	}
}
