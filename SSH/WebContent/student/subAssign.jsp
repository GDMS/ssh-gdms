<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生-查看课题分配结果</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					课题分配结果：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">注意：若课题名称为空，表示原本分配的课题已被删除，但导师不变，并将为你重新分配课题。也可以根据导师要求自行更改题目&gt;&gt;
						<A HREF="student/subAssign!query.action">点击进入</A> </font>
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<TABLE>
						<TR>
							<TD class="tableTop">
								课题名称
							</TD>
							<TD class="tableTop">
								指导老师
							</TD>
						</TR>
						<tr>
							<td class="tableDetail">
								${student.thesis.name}
							</td>
							<td class="tableDetail">
								${student.thesis.teacher.name}
							</td>
						</tr>
					</TABLE>
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">
						已经分配的课题无法删除，如果想换课题请联系指导老师。</font>
				</td>
			</tr>
		</table>
		<center>
			<a HREF="student/main.jsp">返回</a>
		</center>
	</body>
</html>