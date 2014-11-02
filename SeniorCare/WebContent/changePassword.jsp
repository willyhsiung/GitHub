<%-- $Id: changePassword.jsp,v 1.1 2014/08/19 18:52:36 jdurso Exp $ --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="changePassword.title" /></title>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css">
	<link href='<bean:message key="theme.direction" />' rel="stylesheet" type="text/css"><link/>
</head>
<body>
	<div style="border: 0; padding: 0; position: absolute; width: 800px; height: 600px; left: 50%; right: 50%; margin-left: -400px; margin-right: -400px; top: 50%; margin-top: -250px; text-align: center;">
		<html:form action="/changePassword" focus="userName">
		<table align="center" cellpadding="0" cellspacing="0" width="800" bgcolor="#ffffff">
			<tr>
				<td>
					<table class="crdBlueBG" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td align="left" valign="middle" height="50" width="5"></td>
							<td align="left" valign="middle">
								<html:img pageKey="image.title.iconectiv" />
							</td>
						</tr>
					</table>
				</td>
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
					<table cellpadding="10" cellspacing="0" width="100%">
						<tr>
							<td class="left_margin">&nbsp;</td>
							<td align="center" valign="bottom" colspan="2">
								<span class="mm"><bean:message key="changePassword.title"/></span>
							</td>
							<td class="left_margin">&nbsp;</td>
						</tr>
						<tr>
							<td class="left_margin">&nbsp;</td>
							<td align="center" valign="middle" width="60%">
								<html:img pageKey="image.title.crd1" />
							</td>
							<td align="center" valign="middle" width="40%">
								<table border="2" cellpadding="2" cellspacing="2" width="100%">
									<tr>
										<td>
											<table align="center" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ccdaf5">
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="changePassword.prompt.userId" /> </span>
													</td>
													<td>
														<html:text property="userName" size="10" maxlength="8" />
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="changePassword.prompt.oldPassword" /> </span>
													</td>
													<td>
														<html:password property="oldPassword" size="10" maxlength="8"/>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="changePassword.prompt.newPassword" /> </span>
													</td>
													<td>
														<html:password property="newPassword" size="10" maxlength="8"/>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="changePassword.prompt.confirmPassword" /> </span>
													</td>
													<td>
														<html:password property="confirmPassword" size="10" maxlength="8"/>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right">
														<html:submit property="ok" styleClass="bttn">
															<bean:message key="changePassword.button.ok" />
														</html:submit>
													</td>
													<td align="left">
														<html:submit property="cancel" styleClass="bttn">
															<bean:message key="changePassword.button.cancel" />
														</html:submit>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
												  <td>&nbsp;</td>
				                                  <td colspan="2" align="left">
				                                    <SPAN class="notice">
				                                      <bean:message key="changePassword.label.notice"/>
				                                    </SPAN>
				                                    <SPAN class="notice">
				                                      <bean:message key="changePassword.label.noticeText1"/>
				                                      <BR>
				                                      <bean:message key="changePassword.label.noticeText2"/>
				                                    </SPAN>
				                                  </td>
				                                  <td>&nbsp;</td>
				                                </tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
							<td class="left_margin">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<table class="crdBlueBG" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td height="10"></td>
						</tr>
						<tr>
							<td align="center" class="copyright" valign="middle">
								<bean:message key="footer.copyright" />
							</td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</html:form>
	</div>
</body>
</html:html>
