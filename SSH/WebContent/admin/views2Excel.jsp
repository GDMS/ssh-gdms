<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312"%>
<%
	response.setHeader("Content-disposition",
			"inline; filename=views2.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<body>
		<table  BORDER="1">
			<tr>
				<td>name</td>
				<td>credit</td>
				<td>tutor</td>
				<td>preview_teacher</td>
				<td>thesis_name</td>
			</tr>
				<s:iterator value="views2s" var="all" status="st2">
					<tr>
						<td>
							<s:property value="sname" />
						</td>
						<td>
							<s:property value="credit" />
						</td>
						<td>
							<s:property value="tutor" />
						</td>
						<td>
							<s:property value="expr" />
						</td>
						<td>
							<s:property value="subname" />
						</td>
					</tr>
				</s:iterator>
		</table>
	</body>
</html>
