<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生课题分配信息-查看学生信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		<br>
		<!-- -------------------------------------------------------------- -->

		<FONT SIZE="+1" COLOR="#ff6600">该生的个人信息：</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>

				<TD width="115" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					性别
				</TD>
				<TD width="150" ALIGN="center" class="tableTop">
					专业
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					班级
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					联系方式
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					Email
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					学分绩点
				</TD>

			</TR>

			<tr bgcolor="#dcdcdc">
				<td align="center">
					<s:property value="student.studentno"/>
				</td>
				<td align="center">
					<s:property value="student.name"/>
				</td>
				<td align="center">
					<s:property value="student.gender"/>
				</td>
				<td align="center">
					<s:property value="student.stuClass.major.name"/>
				</td>
				<td align="center">
					<s:property value="student.stuClass.name"/>
				</td>
				<td align="center">
					<s:property value="student.phone"/>
				</td>
				<td align="center">
					<s:property value="student.email"/>
				</td>

				<td align="center">
					<s:property value="student.credit"/>
				</td>
			</tr>
		</TABLE>



		<!-- -------------------------------------------------------------- -->
		<center>
			<br>
			<A HREF="admin/subAssignInfo.action">返回</A>
		</center>

	</body>
</html>