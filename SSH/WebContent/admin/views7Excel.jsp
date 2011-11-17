<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view7.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
			<TABLE BORDER="1">
			<TR>
				<TD>
					学号
				</TD>
				<TD>
					姓名
				</TD>
				<TD>
					性别
				</TD>
				<TD>
					专业
				</TD>
				<TD>
					班级
				</TD>
				<TD>
					导师
				</TD>
				<TD>
					课题
				</TD>
				<TD>
					毕设成绩
				</TD>
				<TD>
					学分绩点
				</TD>
				<TD>
					联系方式
				</TD>
				<TD>
					Email
				</TD>
			</TR>
				<s:iterator value="views7s" var="all" status="st2">
					<tr>
						<td align="center">
							<s:property value="sid" />
						</td>
						<td align="center">
							<s:property value="sname" />
						</td>
						<td align="center">
							<s:property value="gender" />
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
							<s:property value="subname" />
						</td>
						<td align="center">
							<s:property value="grade" />
						</td>
						<td align="center">
							<s:property value="credit" />
						</td>
						<td align="center">
							<s:property value="phone" />
						</td>
						<td align="center">
							<s:property value="email" />
						</td>
					</tr>
				</s:iterator>
	
		</TABLE>
	</body>
</html>
