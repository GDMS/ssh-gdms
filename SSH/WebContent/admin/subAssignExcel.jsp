<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=subAssignInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<table border="1">
						<tr>
							<td>StudentNo</td>
							<td>StudentName</td>
							<td>ThesisName</td>
							<td>TeacherName</td>
							<td>Type</td>						
						</tr>
						<s:iterator value="students" var="student" status="st">
							<tr>
								<td>
									<s:property value="studentno" />
								</td>
								<td>
									<s:property value="name" />
								</td>
								<s:if test="thesis==null||thesis.isEmpty()">
									<td>
										no
									</td>
									<td>
										no
									</td>
									<td>
										no
									</td>
								</s:if>
								<s:else>
									<td>
										<s:property value="thesis.name" />
									</td>
									<td>
										<s:property value="thesis.teacher.name" />
									</td>
									<td>
										<s:property value="autoassign" />
									</td>
								</s:else>
							</tr>
						</s:iterator>
					</table>
	</body>
</html>