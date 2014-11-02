package com.yihong.seniorcare.web.helper;

import java.util.Locale;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.util.LabelValueBean;
import com.yihong.seniorcare.common.YHException;

import com.yihong.seniorcare.common.ValuesList;
import com.yihong.seniorcare.common.MessageCatalog;

public final class StaticLists {
	@SuppressWarnings("unused")
	
	
	static public Vector<LabelValueBean> getIntfTypes(String sessionId, Locale locale, boolean isFirstEmpty, boolean removeSmpp) {

		Vector<LabelValueBean> lv = new Vector<LabelValueBean>();
		
		return lv;
	}
	

	static public Vector<LabelValueBean> getUserIds(String sessionId, Locale locale, boolean isFirstEmpty) {
		Vector<LabelValueBean> lv = getLabelAndValueList("USERID", sessionId, locale, isFirstEmpty);
		return lv;
	}

	
	static public Vector<LabelValueBean> getLabelAndValueList(String myField, String sessionId, Locale locale, boolean isFirstEmpty) {
		Vector<LabelValueBean> lovVector = new Vector<LabelValueBean>();
		try {
			// add empty value
			if (isFirstEmpty) {
				lovVector.addElement(new LabelValueBean("", ""));
			}
/*
			ValuesList[] lov = ServerInterfaceWrapper.getServerInterface().getLov(sessionId, myField, locale);
			if (lov == null) {
				return lovVector;
			}
			for (int i = 0; i < lov.length; i++) {		
				lovVector.addElement(new LabelValueBean(lov[i].getValueId().trim(), lov[i].getValue1().trim()));
			}

*/
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return lovVector;
	}

	static public String getLabel(String myField, HttpServletRequest request, String value) throws YHException {
	
		HttpSession session = request.getSession();
		if (session == null) {
			return "";
		}
		
		String sessionId = (String) session.getAttribute("sessionId");
		Locale locale = (Locale) session.getAttribute("locale");
		
		Vector<LabelValueBean> lv = getLabelAndValueList(myField, sessionId, locale, false);
		
		for (int i=0;i <lv.size();i++) {
			LabelValueBean val = lv.get(i);
			if (val.getValue().equals(value)) {
				return val.getLabel();
			}
		}
		return "";
	}
	
	static public Vector<LabelValueBean> getMenuLinks(Locale locale) {
		
		MessageCatalog msgCat = new MessageCatalog("ApplicationResources", locale);
		
		Vector<LabelValueBean> menuLinks = new Vector<LabelValueBean>();
		
		menuLinks.addElement(new LabelValueBean("", ""));
		
		menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.User"), "main.do?page=userList"));
		
		menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.ChangePassword"), "main.do?page=changeCPUserPassword"));
		
		menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.PermissionGroup"), "main.do?page=permissionGroupList"));

		menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.Participant"), "main.do?page=participantList"));
		
		menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.Timer"), "main.do?page=timers"));
		
		//menuLinks.addElement(new LabelValueBean(msgCat.get("admin.main.link.Routing"), "main.do?page=routing"));

		return menuLinks;
	}
}
