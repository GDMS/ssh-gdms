<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=assignAuto.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>管理员-自动分配</title>
	</head>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="65" ALIGN="center" class="tableTop">
					序号
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="320" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					分配形式
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学分绩点
				</TD>
			</TR>
			<s:iterator value="students" var="student" status="st">
				<tr class="tableDetail">
					<td class="tableDetail" align="center">
						<s:property value="%{#st.count}" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="studentno" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.teacher.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.assigned" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="credit" />
					</td>
				</tr>
			</s:iterator>
</TABLE>
		

		
		


	</body>



</html>

