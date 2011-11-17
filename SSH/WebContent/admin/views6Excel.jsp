<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view6.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
			<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="1">
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
					绩点
				</TD>
				<TD>
					预选导师
				</TD>
				<TD>
					课题
				</TD>
				<TD>
					导师
				</TD>
			</TR>

			
				<s:iterator value="views6s" var="all" status="st2">
					<tr>
						<td align="center">
							<s:property value="id.sid" />
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
							<s:property value="credit" />
						</td>
						<td align="center">
							<s:property value="pretutor" />
						</td>
						<td align="center">
							<s:property value="subname" />
						</td>
						<td align="center">
							<s:property value="tutor" />
						</td>
					</tr>
				</s:iterator>
		
		</TABLE>
	</body>
</html>
