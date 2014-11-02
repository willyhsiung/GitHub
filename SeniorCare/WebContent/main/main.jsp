<%-- $Id: main.jsp,v 1.1 2014/08/19 18:52:39 jdurso Exp $ --%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="admin.main.title" /></title>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css" />
	<link href='<bean:message key="theme.direction"/>' rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="include/scripts.js"></script>
</head>
<body>
	<table class="mainTable" style="text-align: center; border: 0; padding=: 0; border-spacing:0px 0px;">
		<tr>
			<td>
				<jsp:include flush="true" page="/include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include flush="true" page="/include/message.jsp"></jsp:include>
				<table style="padding: 0; border-spacing:0px 0px; widt:100%;">
					<tr>
						<td align="center" class="headLineHome">
							<font class="mm"><bean:message key="admin.main.headline.HomePage" /></font>
						</td>
					</tr>
				</table>
				<br />
				<table style="padding: 0; border-spacing:0px 0px; widt:100%;">
					<tr>
						<td style="text-align: center;">
							<table>
								<tr>
									<td style="vertical-align: center;">
										<html:link styleClass="mainlink" page="/main.do?page=userList">
											<html:img border="0" pageKey="image.main.ball" />
										</html:link>
									</td>
									<td>
										<html:link styleClass="mainlink" page="/main.do?page=userList">
											<bean:message key="admin.main.link.User" />
										</html:link>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td valign="middle">
										<html:link styleClass="mainlink" page="/main.do?page=changeCPUserPassword">
											<html:img border="0" pageKey="image.main.ball" />
										</html:link>
									</td>
									<td>
										<html:link styleClass="mainlink" page="/main.do?page=changeCPUserPassword">
											<bean:message key="admin.main.link.ChangePassword" />
										</html:link>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td valign="middle">
										<html:link styleClass="mainlink" page="/main.do?page=timers">
											<html:img border="0" pageKey="image.main.ball" />
										</html:link>
									</td>
									<td>
										<html:link styleClass="mainlink" page="/main.do?page=timers">
											<bean:message key="admin.main.link.Timer" />
										</html:link>
									</td>
								</tr>		
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="bottom">
				<jsp:include flush="true" page="/include/footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html:html>
