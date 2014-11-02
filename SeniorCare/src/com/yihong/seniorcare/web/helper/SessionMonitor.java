package com.yihong.seniorcare.web.helper;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

import org.apache.log4j.Category;

public class SessionMonitor implements HttpSessionListener {
	//@SuppressWarnings("unused")
	
    
	static Category log = Category.getInstance(SessionMonitor.class.getName());
	 
	private static int activeSessions = 0;
    static private SessionMonitor instance;
    String id ;
 
    public static SessionMonitor getInstance(){
       return instance == null? (instance = new SessionMonitor()) : instance;}

    /* Session Creation Event */
    public void sessionCreated(HttpSessionEvent se) {
        id = se.getSession().getId();
        activeSessions++;
        log.info("New Session Created: session id: " + id + "; number of active sessions: " +   activeSessions);
    }

    /* Session Invalidation Event */
    public void sessionDestroyed(HttpSessionEvent se) {
        id = se.getSession().getId();
        String sessionId = (String) se.getSession().getAttribute("sessionId");

        if(activeSessions > 0)
            activeSessions--;
        log.info("Session Destroyed: session id: " + sessionId + "; request sessionId: " + id + "; number of active sessions: " +   activeSessions);
        /*
        try {
            if (sessionId != null){
            	ServerInterfaceWrapper.getServerInterface().disconnectSession(sessionId);
            }
        } catch (Exception ex) {}
        */
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}
