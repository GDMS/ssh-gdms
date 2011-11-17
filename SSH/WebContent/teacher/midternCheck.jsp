<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-中期检查</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					您要检查的学生：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<TABLE>
						<TR>
							<TD class="tableTop">
								学号
							</TD>
							<TD class="tableTop">
								姓名
							</TD>
							<TD class="tableTop">
								课题名称
							</TD>
							<TD class="tableTop">
								警告
							</TD>
							<TD class="tableTop">
								检查
							</TD>
						</TR>
						<s:iterator value="thesises" var="thesis" status="st">
							<tr>
								<td class="tableDetail">
									<s:property value="student.studentno" />
								</td>
								<td class="tableDetail">
									<s:property value="student.name" />
								</td>
								<td class="tableDetail">
									<s:property value="name" />
								</td>
								<td class="tableDetail">
									<s:property value="student.studentScore.warn" />
								</td>
								<td class="tableDetail">
									<A
										HREF="teacher/teacherSetRemark!query.action?studentno=${student.studentno}">检查</A>
								</td>
							</tr>
						</s:iterator>
					</TABLE>
					<br>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>
	</body>
</html>