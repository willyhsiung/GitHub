<%-- $Id: header.jsp,v 1.1 2014/08/19 18:52:39 jdurso Exp $ --%>
<%@page language="java"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:form action="/menu">
	<table class="crdBlueBG" style="padding: 2; border-spacing: 0; width: 100%;">
		<tr>
			<td rowspan="2" style="text-align: left; vertical-align: bottom; ">
				<html:img pageKey="image.title.crd"/>
			</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td style="text-align: center; vertical-align: middle; white-space: nowrap;">
				<span class="headdata">
					<bean:message key="admin.header.prompt.admin.user"/>
					<bean:write name="userId"/>
				</span>
			</td>
			<td style="text-align: right; vertical-align: bottom; white-space: nowrap;">
				<span class="headdata">
					<bean:message key="admin.menu.prompt.goTo"/>
						<html:select onchange="goTo(this)" property="menu" styleClass="goto">
							<html:options collection="valuesList.menuLinks" property="value" labelProperty="label"/>
					</html:select>
				</span>
			</td>
			<td style="text-align: right; vertical-align: bottom; white-space: nowrap;">
				<html:link page="/main.do" style="text-decoration: none;">
					<html:img pageKey="image.title.home" border="0" />
				</html:link>
				<html:img pageKey="image.title.hand" style="cursor:pointer;" onmousedown="logout();" />
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</html:form>
