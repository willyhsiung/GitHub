<%-- $Id: login.jsp,v 1.1 2014/08/19 18:52:36 jdurso Exp $ --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.yihong.seniorcare.action.LoginAction" %>
<jsp:useBean class="com.yihong.seniorcare.actionforms.LoginActionForm" id="loginActionForm" scope="request" />

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="admin.title.appl" /> - <bean:message key="login.title" /></title>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css">
	<link href='<bean:message key="theme.direction" />' rel="stylesheet" type="text/css"><link/>
</head>
<body onload="startTimeKeep()">;
	<div style="border: 0; padding: 0; position: absolute; width: 800px; height: 600px; left: 50%; right: 50%; margin-left: -400px; margin-right: -400px; top: 50%; margin-top: -250px; text-align: center;">
		<html:form action="/login" focus="userName">
		<table align="center" cellpadding="0" cellspacing="0" width="800" bgcolor="#ffffff">
			<tr>
				<td>
					<table class="crdBlueBG" style="clear: both; border-collapse: collapse; border-spacing: 0; width: 100%;" >
						<tr>
							<td align="left" valign="middle" height="50" width="5"></td>
							<td align="left" valign="middle">
								<html:img pageKey="image.title.yihong" />
							</td>
							<td align="right" nowrap="nowrap">
								<span class="headdata"> <%=LoginAction.release%> </span>
							</td>
							<td width="5"></td>
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
					<table style="cellpadding: 0; cellspacing: 0; width: 100%">
						<tr>
							<td class="left_margin">&nbsp;</td>
							<td style="text-align: center;" valign="bottom" colspan="2">
								<span class="mm"><bean:message key="admin.owner"/></span>
							</td>
							<td class="left_margin">&nbsp;</td>
						</tr>
						<tr>
							<td class="left_margin">&nbsp;</td>
							<td style="text-align: center;" valign="middle" width="50%" >
								<html:img pageKey="image.title.crd1" />
							</td>
							<td style="text-align: center; valign: middle; width: 50%">
								<table border="2" cellpadding="2" cellspacing="2" width="100%">
									<tr>
										<td>
											<table align="center" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ccdaf5">
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="login.prompt.userId" /> </span>
													</td>
													<td>
														<html:text property="userName" size="10" maxlength="8" />
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right" nowrap="nowrap">
														<span class="L1"> <bean:message key="login.prompt.password" /> </span>
													</td>
													<td>
														<html:password property="password" size="10" maxlength="8"/>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
						                            <td colspan="2">
						                              <span class="notice">
						                                <bean:message key="login.text.L1"/>
						                                <bean:message key="login.text.L2"/>
						                                <bean:message key="login.text.L3"/>
						                                <bean:message key="login.text.L4"/>
						                                <bean:message key="login.text.L5"/>
						                                <bean:message key="login.text.L6"/>
						                              </span>
						                            </td>
						                            <td>&nbsp;</td>
						                        </tr>
												<tr>
													<td>&nbsp;</td>
													<td align="right">
														<html:submit property="submit" styleClass="bttn">
															<bean:message key="login.button.login" />
														</html:submit>
													</td>
													<td align="left">
														<html:submit property="changePassword" styleClass="bttn">
															<bean:message key="login.button.changePassword" />
														</html:submit>
													</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td colspan="4" align="center">
														<input type="text" style="text-align: center" name="face" size="8" value="" align="middle">
														<html:hidden property="systemTime" />
													</td>
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
<script type="text/javascript">


	function createCookie(name, value, days) {
		var expires = "";

		if (days) {
			var date = new Date();
			date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
			expires = "; expires=" + date.toGMTString();
		}

		var cookie = name + "=" + value + expires + "; path=" + "/";
		document.cookie = cookie;
	}
</script>
<script type="text/javascript">
	var timerID = null;
	var timerRunning = false;
	var timeValue= "";

	function stopTimeKeep() {

		if (timerRunning)
			clearTimeout(timerID);
		timerRunning = false;
	}
	
	function startTimeKeep() {

		createCookie("JavaScriptEnabledCheck", 1, 0);
		
		stopTimeKeep() ;

		timeValue = document.forms["loginActionForm"].systemTime.value;

		showtime();
		
	}

	function showtime() {
		
		if (timeValue !="") {
			
			var hours = eval(timeValue.substring(0,2));
			var minutes = eval(timeValue.substring(3,5));
 			var seconds = eval(timeValue.substring(6,8)) ;

 			seconds=eval(seconds)+1;
			if (eval(seconds)<10) seconds="0"+seconds;

			if ( seconds>=60) {
				seconds="00";
				minutes=eval(minutes)+1;
			}
			
			if (eval(minutes)<10) minutes="0"+minutes;

			if (minutes >=60) {
				minutes="00";
				hours= eval(hours)+1;
			}
			
			if (eval(hours)<10) hours="0"+hours;

			if (hours>=24){
				hours="00"
			}

			timeValue = hours + ":" + minutes + ":" + seconds

			document.forms["loginActionForm"].face.value = timeValue;

			timerID = setTimeout("showtime()",1000) ;

			timerRunning = true ;
			
		}
		
	}
</script>
</html:html>
