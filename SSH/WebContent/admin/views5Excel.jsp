<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view5.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
			<TR>
				<TD width="115" ALIGN="center" class="tableHeading">
					姓名
				</TD>
				<TD width="135" ALIGN="center" class="tableHeading">
					性别
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					学分绩点
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					导师
				</TD>
				<TD width="135" ALIGN="center" class="tableHeading">
					专业
				</TD>
				<TD width="135" ALIGN="center" class="tableHeading">
					班级
				</TD>
				<TD width="135" ALIGN="center" class="tableHeading">
					分配情况
				</TD>

			</TR>

	
				<s:iterator value="views5s" var="all" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="sname" />
						</td>
						<td align="center">
							<s:property value="gender" />
						</td>
						<td align="center">
							<s:property value="credit" />
						</td>
						<td align="center">
							<s:property value="tutor" />
						</td>
						<td align="center">
							<s:property value="major" />
						</td>
						<td align="center">
							<s:property value="class_" />
						</td>
						<td align="center">
							<s:property value="assign" />
						</td>
					</tr>
				</s:iterator>
	
		</TABLE>

	</body>
</html>
