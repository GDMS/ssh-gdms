<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理教师信息-查看注册课题</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		
		<br>

		<FONT SIZE="+1" COLOR="#ff6600">tutor老师已提交的课题信息：</FONT>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="320" ALIGN="center" class="tableHeading">
					课题名称
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					题目类型
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					题目性质
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					承担方式
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					删除
				</TD>
			</TR>


			<!-- html code here below -->
			<tr bgcolor="#dcdcdc">
				<td align="center">
					subname
				</td>
				<td align="center">
					type
				</td>
				<td align="center">
					property
				</td>
				<td align="center">
					mode
				</td>
				<td align="center">
					<A HREF="admin/subRegDel.jsp">删除</A>
				</td>
			</tr>
			<!-- html code here up -->

		</TABLE>
		<br>
		<br>
		<center>
			<A HREF="admin/teacherInfoManage.jsp">返回</A>
		</center>


	</body>
</html>