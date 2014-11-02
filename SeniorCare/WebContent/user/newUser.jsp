<%-- $Id: newUser.jsp,v 1.1 2014/08/19 18:52:40 jdurso Exp $ --%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="admin.newUser.title" /></title>
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
			<td>
				<table style="text-align: center; width: 100%">
					<tr>
						<td class="left_margin"></td>
						<td>
							<html:form action="/newUser">
								<jsp:include flush="true" page="/include/message.jsp"></jsp:include>
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr>
										<td align="center" class="headLine">
											<font class="mm"> <bean:message key="admin.newUser.title" /> </font>
										</td>
									</tr>
								</table>
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr>
										<td>
											<html:submit property="save" styleClass="bttn">
												<bean:message key="admin.button.save" />
											</html:submit>
										</td>
									</tr>
								</table>
								<br />
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.participantId" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:select name="newUserActionForm" property="participantId" onchange="submit();">
												<html:options collection="valuesList.participantIds" property="value" labelProperty="label" />
											</html:select>
										</td>
									</tr>
								</table>
								<br />
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr class="lightBlue">
										<td align="center">
											<span class="H2"><bean:message key="admin.label.userInfo" /> </span>
										</td>
									</tr>
								</table>
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.userId" /> </span>
										</td>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.userName" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:text property="userId" name="newUserActionForm" maxlength="8" size="15"  onkeyup="formatNonBlankSpace(this);" />
										</td>
										<td colspan="2">
											<html:text property="userName" name="newUserActionForm" maxlength="80" size="50"  />
										</td>
									</tr>
									<tr>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.password" /> </span>
										</td>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.confirmPassword" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:password property="password" name="newUserActionForm"  maxlength="15" size="20" />
										</td>
										<td>
											<html:password property="confirmPassword" name="newUserActionForm" maxlength="15" size="20" />
										</td>
									</tr>
									<tr>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.phone" /> </span>
										</td>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.email" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:text property="phone" name="newUserActionForm" maxlength="15" size="20" onkeyup="formatNumeric(this);"/>
										</td>
										<td>
											<html:text property="email" name="newUserActionForm" maxlength="30" size="35" />
										</td>
									</tr>
									<tr>
										<td>
											<span class="L1"> <bean:message key="admin.prompt.permissionGroup" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:select property="permissionGroup" name="newUserActionForm">
												<html:options collection="valuesList.groupIds" property="value" labelProperty="label" />
											</html:select>
										</td>
									</tr>
								</table>
								<br />
								<table style="cellpadding: 0; cellspacing: 0; width: 100%">
									<tr>
										<td>
											<html:submit property="save" styleClass="bttn">
												<bean:message key="admin.button.save" />
											</html:submit>
										</td>
									</tr>
								</table>
							</html:form>
						</td>
					</tr>
				</table>
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
