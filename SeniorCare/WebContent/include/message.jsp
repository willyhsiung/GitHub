<%--$Id: message.jsp,v 1.1 2014/08/19 18:52:39 jdurso Exp $ --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css">
	<link href='<bean:message key="theme.direction" />' rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="include/scripts.js" type="text/javascript"></script>
</head>
<body>
	<table cellpadding="5" cellspacing="0" width="100%">
		<tr>
			<td>
				<logic:messagesPresent message="false">
					<bean:message key="errors.header" />
					<UL>
						<html:messages id="error" message="false">
							<LI>
								<bean:write name="error" />
							</LI>
						</html:messages>
					</UL>
					<bean:message key="errors.footer" />
				</logic:messagesPresent> 
				<logic:messagesPresent message="true">
					<bean:message key="message.header" />
					<UL>
						<html:messages id="message" message="true">
							<LI>
								<bean:write name="message" />
							</LI>
						</html:messages>
					</UL>
					<bean:message key="message.footer" />
				</logic:messagesPresent>
			</td>
		</tr>
	</table>
</body>
</html:html>
