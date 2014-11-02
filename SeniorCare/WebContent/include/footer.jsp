<%--$Id: footer.jsp,v 1.1 2014/08/19 18:52:39 jdurso Exp $ --%>
<%@page language="java"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:html xhtml="true" lang="true">
<head>
	<link href="theme/crdb.css" rel="stylesheet" type="text/css">
	<link href='<bean:message key="theme.direction" />' rel="stylesheet" type="text/css"><link/>
</head>
<body>
	<table class="crdBlueBG" style="cellpadding: 0; cellspacing: 0; width: 100%;">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td width="130" align="center" valign="middle"></td>
			<td class="copyright" style="text-align: center; vertical-align: middle;">
				<bean:message key="footer.copyright"/>
			</td>
			<td style="text-align: center; vertical-align: middle;">
				<html:img pageKey="image.title.iconectiv" />
			</td>
		</tr>
		<tr>
			<td height="10"></td>
		</tr>
	</table>
</body>
</html:html>
