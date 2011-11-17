<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view3.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<TABLE border="1">
			<TR>
				<TD>
					题目
				</TD>
				<TD>
					姓名
				</TD>
				<TD>
					学号
				</TD>
				<TD>
					专业
				</TD>
				<TD>
					班级
				</TD>
				<TD>
					教师
				</TD>
				<TD>
					性别
				</TD>
				<TD>
					绩点
				</TD>
				<TD>
					类型
				</TD>
				<TD>
					性质
				</TD>
				<TD>
					承担方式
				</TD>
			</TR>

			
				<s:iterator value="views3s" var="all" status="st2">
					<tr>
						<td align="center">
							<s:property value="subname" />
						</td>
						<td align="center">
							<s:property value="sname" />
						</td>
						<td align="center">
							<s:property value="sid" />
						</td>
						<td align="center">
							<s:property value="major" />
						</td>
						<td align="center">
							<s:property value="class_" />
						</td>
						<td align="center">
							<s:property value="tutor" />
						</td>
						<td align="center">
							<s:property value="gender" />
						</td>
						<td align="center">
							<s:property value="credit" />
						</td>
						<td align="center">
							<s:property value="type" />
						</td>
						<td align="center">
							<s:property value="property" />
						</td>
						<td align="center">
							<s:property value="mode" />
						</td>
					</tr>
				</s:iterator>
		</TABLE>
	</body>
</html>
