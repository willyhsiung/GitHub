<%-- $Id: changeCPUserPassword.jsp,v 1.1 2014/08/19 18:52:37 jdurso Exp $ --%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="admin.changeUserPassword.title" /></title>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css" />
	<link href='<bean:message key="theme.direction"/>' rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="include/scripts.js"></script>
</head>
<body>
	<table class="mainTable" style="text-align: center; border: 0; cellpadding: 0; cellspacing: 0; ">
		<tr>
			<td><jsp:include flush="true" page="/include/header.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center">
				<jsp:include flush="true" page="/include/message.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
				<html:form action="/changeCPUserPassword">
				<table style="cellpadding: 0; cellspacing: 0; width: 100%;">
					<tr>
						<td align="center" class="headLine">
							<font class="mm"> <bean:message key="admin.changeUserPassword.title" /> </font>
						</td>
					</tr>
				</table>
				<table style="cellpadding: 0; cellspacing: 0; width: 100%;">
					<tr>
						<td align="center">
							<table style="text-align: center;  cellpadding: 2; cellspacing: 0;">
								<tr>
									<td style="text-align: right;">
										<span class="L1"> <bean:message key="changePassword.prompt.userId" /> </span>
									</td>
									<td>
										<html:text property="userName" size="20" maxlength="12" />
									</td>
								</tr>
								<tr>
									<td style="text-align: right;">
										<span class="L1"> <bean:message key="changePassword.prompt.newPassword" /> </span>
									</td>
									<td>
										<html:password property="newPassword" size="20" maxlength="15" />
									</td>
								</tr>
								<tr>
									<td align="right">
										<span class="L1"> <bean:message key="changePassword.prompt.confirmPassword" /> </span>
									</td>
									<td>
										<html:password property="confirmPassword" size="20" maxlength="15" />
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="right">
										<html:submit property="ok" styleClass="bttn">
											<bean:message key="changePassword.button.ok" />
										</html:submit>
									</td>
									<td>
										<html:submit property="clear" styleClass="bttn">
											<bean:message key="admin.button.clear" />
										</html:submit>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</html:form>
			</td>
		</tr>
		<tr>
			<td valign="bottom">
				<jsp:include flush="true" page="/include/footer.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html:html>