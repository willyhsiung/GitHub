package com.yihong.seniorcare.web.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yihong.seniorcare.action.LoginAction;
import com.yihong.seniorcare.common.LogHandle;



public class WebActionHandler {
	@SuppressWarnings("unused")
	
	private static LogHandle logHandle = new LogHandle(WebActionHandler.class);
	private static Logger log = logHandle.getLogHandle(WebActionHandler.class);
	
	  private WebActionHandler() {
	  }
	  
	static public void verifySession(HttpServletRequest request, String formName) throws Exception {
		
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		
		//ServerInterfaceWrapper.getServerInterface().verifySessionId(sessionId);
		
		return;
	}

	public static ActionForward disconnectSession(ActionMapping mapping, HttpServletRequest request) {
		ActionForward forward;
		
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		try {
		if (log.isInfoEnabled()) {
			log.info("Disconnect Saved sessionID:" + sessionId);
			log.info("Disconnect Request SessionId: " +
		request.getRequestedSessionId());
		}
	//	ServerInterfaceWrapper.getServerInterface().disconnectSession(sessionId);
		
		} catch (Exception ex) {
			log.error(ex);
		}
		request.getSession().invalidate();
		forward = mapping.findForward("logoff");
		
		return forward;
	}

	public static String getCookie(String cookie, HttpServletRequest request) {
		// get cookie
		try {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals(cookie)) {
		// found cookie
		return cookies[i].getValue();
		}
		}
		return "";
		} catch (Exception ex) {
		return null;
	}
}
}
