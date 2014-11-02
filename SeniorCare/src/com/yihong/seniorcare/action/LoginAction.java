package com.yihong.seniorcare.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yihong.seniorcare.actionforms.LoginActionForm;
import com.yihong.seniorcare.common.LogHandle;
import com.yihong.seniorcare.common.ProductProperties;
import com.yihong.seniorcare.common.User;
import com.yihong.seniorcare.common.YHException;
import com.yihong.seniorcare.web.helper.StaticLists;
import com.yihong.seniorcare.web.helper.WebActionHandler;

public class LoginAction extends BaseAction {
	@SuppressWarnings("unused")

	private static LogHandle logHandle = new LogHandle(LoginAction.class);
	private static Logger log = logHandle.getLogHandle(LoginAction.class);
	
	static ProductProperties productProperties = new ProductProperties();
	final public static String release = productProperties.getProperty("release", "").trim();
	
	public LoginAction() {
	}
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	
		
	String logoff = httpServletRequest.getParameter("logoff");
    if (logoff != null && !logoff.equals("")) {
    	log.info("logoff button clicked");
        try {
        	httpServletRequest.getParameterMap().remove("logoff");
        } catch (Exception ex) {}
       
        ActionForward forward = WebActionHandler.disconnectSession(actionMapping, httpServletRequest);           
        return forward;
    }
    
    HttpSession session = httpServletRequest.getSession();
    
	// Initialize errors and messages objects
     ActionMessages messages = new ActionMessages();

	// Set character encoding based on browser locale
	log.debug("before setting char coding.. file encoding: " + System.getProperty("file.encoding"));

	java.util.Properties pi = System.getProperties();
	pi.put("file.encoding", "UTF-8");
	System.setProperties(pi);

	log.debug("after setting char coding.. file encoding: " + System.getProperty("file.encoding"));

	System.setProperty("NPCJVMFlag", "JBoss");
	
	java.util.Locale locale = httpServletRequest.getLocale();
	setLocale(httpServletRequest, locale);
	// Set locale for session
	httpServletRequest.getSession().setAttribute("locale", locale);

	log.debug("Locale Language: " + locale.getLanguage());
	log.debug("Locale country: " + locale.getCountry());

	LoginActionForm loginActionForm = (LoginActionForm) actionForm;

	// Get system time to show it on screen as a ref.

	String systemTime = (new Timestamp(System.currentTimeMillis())).toString().substring(11);
	
	log.debug("System Time" + systemTime);
	loginActionForm.setSystemTime(systemTime);

	log.debug("in LoginAction:perform");

	// First load show page
	if (loginActionForm.getUserName() == null || loginActionForm.getPassword() == null) {
		loginActionForm.setUserName("");
		loginActionForm.setPassword("");
		loginActionForm.setSystemTime(systemTime);
		httpServletRequest.setAttribute("loginActionForm", actionForm);
		return (actionMapping.findForward("failure"));
	}

	httpServletRequest.getCookies();
	 
		User user = null;
		
		try {
			boolean isAdminUser = false;
			
			//isAdminUser = ServerInterfaceWrapper.getServerInterface().isAdminUser(loginActionForm.getUserName());
			isAdminUser=true;
			
			if (!isAdminUser) {
				throw new YHException("NPC3005E");
			}
			
			boolean forceLogin = false;

			String forceLoginFlag = (String) httpServletRequest.getSession().getAttribute("forceLogin");

			String lastUserId = (String) httpServletRequest.getSession().getAttribute("lastUserId");

			if ((forceLoginFlag != null && lastUserId != null && forceLoginFlag.equals("Y") && 
					lastUserId.equals(loginActionForm.getUserName())) || 
					(loginActionForm.getChangePassword() != null &&
					loginActionForm.getChangePassword().equals("Change Password"))) {
				forceLogin = true;
			}

			httpServletRequest.getSession().setAttribute("lastUserId", loginActionForm.getUserName());
			
			//user = ServerInterfaceWrapper.getServerInterface().establishSession(loginActionForm.getUserName(),
			//				loginActionForm.getPassword(), locale, forceLogin);
			user = new User();
			user.userId = loginActionForm.getUserName();
			user.password = loginActionForm.getPassword();
			

			if (log.isDebugEnabled()) {
				log.info("Valid logon. Session Id:" + user.sessionId);
			}

			// store the application sessionId in the sessions table
			// note that this is not the same as the servlet sessionId
			httpServletRequest.getSession(true);
			httpServletRequest.getSession().setAttribute("sessionId", user.sessionId);

			httpServletRequest.getSession().setAttribute("forceLogin", "N");
		} catch (Exception ex) {
            if (ex instanceof YHException) {
                log.error("LoginAction.execute: Error:" + ex.getMessage());
                YHException nex = (YHException) ex;
                if (nex.getErrorCode().compareTo("NPC3003E") == 0) {
                    session.setAttribute("forceLogin", "Y");
                } else {
                    session.setAttribute("forceLogin", "N");
                }

                messages.add(ActionMessages.GLOBAL_MESSAGE,
                             new ActionMessage("error.login.exception",
                                               nex.getErrorMsg(locale)));
                saveErrors(httpServletRequest, messages);

                return (actionMapping.findForward("failure"));

            } else {
            	YHException nex = new YHException("NPC0001E", ex.getMessage().trim(), false);
                log.error("LoginAction.execute: unexpected error: "  + ex.getMessage().trim());
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.catch.exception", nex.getErrorMsg(locale)));
                saveMessages(httpServletRequest, messages);
                return (actionMapping.findForward("failure"));
            }
        }
 
		session.setAttribute("sessionId", user.sessionId);
		session.setAttribute("userId", user.userId);
		session.setAttribute("cpId", "");
		
		httpServletRequest.getSession().setAttribute("valuesList.menuLinks", StaticLists.getMenuLinks(locale));

		if (loginActionForm.getChangePassword() != null) {
			return (actionMapping.findForward("changePassword"));
		}
		else if (loginActionForm.getSubmit() != null) {
			return (actionMapping.findForward("success"));
		}
		else {
			return (actionMapping.findForward("failure"));
		}
	}
}
