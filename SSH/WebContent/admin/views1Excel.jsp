<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="application/vnd.ms-excel; charset=gb2312" %>
<%
   response.setHeader("Content-disposition","inline; filename=view1.xls");
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
	<body>
		<TABLE border="1">
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
					学分绩点
				</TD>
				<TD>
					导师
				</TD>
				<TD>
					专业
				</TD>
				<TD>
					班级
				</TD>
				<TD>
					分配情况
				</TD>
				<TD>
					自动分配
				</TD>
			</TR>
			<s:iterator value="views1s" var="all" status="st2">
					<tr>
						<td>
							<s:property value="sid" />
						</td>
						<td>
							<s:property value="sname" />
						</td>
						<td>
							<s:property value="gender" />
						</td>
						<td>
							<s:property value="credit" />
						</td>
						<td>
							<s:property value="tutor" />
						</td>
						<td>
							<s:property value="major" />
						</td>
						<td>
							<s:property value="class_" />
						</td>
						<td>
							<s:property value="assign" />
						</td>
						<td>
							<s:property value="autoassign" />
						</td>
					</tr>
				</s:iterator>
		</TABLE>
	</body>
</html>
