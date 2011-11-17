<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=subAssignedInfo.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="45" ALIGN="center" class="tableTop">
					序号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					课题类型
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					课题性质
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					承担方式
				</TD>
			
			
			<s:iterator value="students" var="student" status="st">
			<tr >
			
			<td align="center" class="tableDetail">${st.count}</td>
			<td align="center" class="tableDetail"><s:property value="studentno"/></td>
			<td align="center" class="tableDetail"><s:property value="name"/></td>
			
			<td align="center" class="tableDetail"><s:property value="thesis.name"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.teacher.name"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.type"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.property"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.mode"/></td>
			
			</s:iterator>



		</TABLE>

	</body>
</html>
