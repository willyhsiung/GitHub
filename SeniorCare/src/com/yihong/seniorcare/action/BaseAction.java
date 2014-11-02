package com.yihong.seniorcare.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yihong.seniorcare.common.YHException;

public class BaseAction extends Action {
	@SuppressWarnings("unused")
	
	public ActionForward saveErrors(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, Exception ex) {

		ActionMessages messages = new ActionMessages();
		
		Locale locale = null;
		if (ex instanceof YHException) {
			YHException nex = (YHException) ex;
			if (nex.getErrorCode().equals("NPC3004E")) {
				locale = request.getLocale();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", nex.getErrorMsg(locale)));
				saveErrors(request, messages);
				return mapping.findForward("logoff");
			}
			else if (nex.getErrorCode().equals("NPC4090E")) {
				YHException npcEx = (YHException) ex;
				locale = (Locale) request.getSession().getAttribute("locale");
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", npcEx.getGUIDataValErrMsg(locale, nex.getErrorCode())));
				saveErrors(request, messages);
				return mapping.findForward("failure");
			}
			else {
				locale = (Locale) request.getSession().getAttribute("locale");
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", nex.getErrorMsg(locale)));
				saveErrors(request, messages);
				return mapping.findForward("failure");
			}
		}
		else {
			locale = (Locale) request.getSession().getAttribute("locale");
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", new YHException("NPC0001", ex.getMessage()).getErrorMsg(locale)));
			saveErrors(request, messages);
			return mapping.findForward("failure");
		}
	}
}
