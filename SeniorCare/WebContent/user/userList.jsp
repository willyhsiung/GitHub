<%-- $Id: userList.jsp,v 1.2 2014/09/24 18:55:52 jdurso Exp $ --%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="admin.userList.title" /></title>
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
				<table style="text-align: center; width: 100%;">
					<tr>
						<td class="left_margin"></td>
						<td>
							<html:form action="/userList">
								<jsp:include flush="true" page="/include/message.jsp"></jsp:include>
								<table style="cellpadding: 0; cellspacing: 0; width: 100%;">
									<tr>
										<td align="center" class="headLine">
											<font class="mm"> <bean:message key="admin.userList.title" /> </font>
										</td>
									</tr>
								</table>
								<table style="padding: 2; border-spacing:0px 0px; width: 50%;">
									<tr class="lightBlue">
										<td nowrap="nowrap">
											<span class="H2"><bean:message key="admin.label.searchCriteria" /> </span>
										</td>
									</tr>
								</table>
								<table style="padding: 0; border-spacing:0px 0px; width: 50%;">
									<tr>
										<td>
											<span class="L1"><bean:message key="admin.prompt.participantId" /> </span>
										</td>
										<td>
											<span class="L1"><bean:message key="admin.prompt.userId" /> </span>
										</td>
									</tr>
									<tr>
										<td>
											<html:select property="participantId">
												<html:options collection="valuesList.participantIds" property="value" labelProperty="label" />
											</html:select>
										</td>
										<td>
											<html:select property="userId">
												<html:options collection="valuesList.userIds" property="value" labelProperty="label" />
											</html:select>
										</td>
									</tr>
								</table>
								<br />
								<table style="padding: 0;  border-spacing:0px 0px; width: 100%;">
									<tr>
										<td>
											<html:submit property="retrieve" styleClass="bttn">
												<bean:message key="admin.button.retrieve" />
											</html:submit>
											<html:submit property="clear" styleClass="bttn">
												<bean:message key="admin.button.clear" />
											</html:submit>
											<html:submit property="add" styleClass="bttn">
												<bean:message key="admin.button.addUser" />
											</html:submit>
										</td>
									</tr>
								</table>
								<br />
								<table  style="padding: 2;  border-spacing:0px 0px; width: 100%;">
									<tr class="lightBlue">
										<td>
											<span class="H2"> <bean:message key="admin.label.searchResults" /> </span>
											<logic:notEmpty property="pageNumber" name="userListActionForm">
											<span class="H2"> ( 
		           								<bean:write name="userListActionForm" property="recordFrom" /> - 
		           								<bean:write name="userListActionForm" property="recordTo" /> 
												<bean:message key="admin.label.of" /> 
												<bean:write name="userListActionForm" property="numberofRecords" /> )
			         						</span>
			         						</logic:notEmpty>
										</td>
										<logic:notEmpty property="pageNumber" name="userListActionForm">
										<td align="right">
											<span class="H2">
												<bean:message key="admin.prompt.page" />
												<html:select property="topPageSelector" onchange="gotoPage(this);">
													<html:options property="pagesList" name="userListActionForm" />
												</html:select>
											</span>
										</td>
										</logic:notEmpty>
									</tr>
								</table>
								<table  style="padding: 0;  border-spacing:0px 0px; width: 100%;" id="results">
									<tr class="crdBlueBG">
										<td></td>
										<td class="ts1" nowrap="nowrap">
											<bean:message key="admin.label.userId" />
										</td>
										<td class="ts1" nowrap="nowrap">
											<bean:message key="admin.label.userName" />
										</td>
										<td class="ts1" nowrap="nowrap">
											<bean:message key="admin.label.permissionGroup" />
										</td>
										<td class="ts1" nowrap="nowrap">
											<bean:message key="admin.label.participantId" />
										</td>
									</tr>
									<logic:iterate name="userListActionForm" property="userList" id="userList" indexId="index">
										<tr class="<%=(index.intValue() % 2 == 0 ? "odd" : "even")%>">
											<td>
												<html:checkbox property='<%="userList[" + index + "].removeFlag"%>' name="userListActionForm"></html:checkbox>
											</td>
											<td nowrap="nowrap">
												<a
													href="editUser.do?userId=<bean:write name="userList" property="userId" />&participantId=<bean:write name="userList" property="participantId" />">
													<bean:write name="userList" property="userId" />
													<html:hidden property='<%="userList[" + index + "].userId"%>' name="userListActionForm" />
												</a>
											</td>
											<td nowrap="nowrap">
												<bean:write name="userList" property="userName" />
											</td>
											<td nowrap="nowrap">
												<bean:write name="userList" property="permissionGroup" />
											</td>
											<td nowrap="nowrap">
												<bean:write name="userList" property="participantId" />
											</td>
										</tr>
									</logic:iterate>
								</table>
								<table style="padding: 2; border-spacing:0px 0px; width: 100%;">
									<logic:notEmpty property="pageNumber" name="userListActionForm">
										<tr class="lightBlue">
											<td align="right">
												<span class="H2">
													<bean:message key="admin.prompt.page" />
													<html:select property="botPageSelector" onchange="gotoPage(this);">
														<html:options property="pagesList" name="userListActionForm" />
													</html:select>
												</span>
											</td>
										</tr>
									</logic:notEmpty>
								</table>
								<br />
								<table style="padding: 0; border-spacing:0px 0px; width: 100%;">
									<tr>
										<td></td>
										<td>
											<html:submit property="add" styleClass="bttn">
												<bean:message key="admin.button.addUser" />
											</html:submit>
											<html:submit property="delete" styleClass="bttn" onclick="confirmChkDelete('userListActionForm', 'deleteUsers');">
												<bean:message key="admin.button.deleteChkUser" />
											</html:submit>
											<html:hidden property="deleteUsers" name="userListActionForm"/>
										</td>
									</tr>
								</table>
								<br />
								<html:hidden property="numberofRecords" />
								<html:hidden property="recordFrom" />
								<html:hidden property="recordTo" />
								<html:hidden property="isNewQuery" />
								<html:hidden property="pageNumber" />
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