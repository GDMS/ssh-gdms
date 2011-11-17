<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/studentInfo.js"></script>
		<br>
		<!-- -------------------------------------------------------------- -->

		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">已注册的学生信息：</font>
				</td>

				<td>
					<a href="admin/studentInfo!Excel.action?printable=true">点此导出Excel</a>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>

				<TD width="115" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					密码
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					性别
				</TD>
				<TD width="135" ALIGN="center" class="tableTop">
					专业
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					班级
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					学分绩点
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					联系方式
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					Email
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					修改
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					删除
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="students" var="student" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="studentno" />
						</td>
						<td align="center">
							<s:property value="name" />
						</td>
						<td align="center">
							<s:property value="password" />
						</td>
						<td align="center">
							<s:property value="gender" />
						</td>
						<td align="center">
							<s:property value="stuClass.major.name" />
						</td>
						<td align="center">
							<s:property value="stuClass.name" />
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
						<td align="center">
							<A
								HREF="admin/studentInfoMod!query.action?studentno=${student.studentno}">修改</A>
						</td>
						<td align="center">
							<A
								HREF="admin/studentInfo!delete.action?studentno=${student.studentno}">删除</A>
						</td>
					</tr>
				</s:iterator>
			</tr>


		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/studentInfo!query.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="admin/studentInfo!query.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>


		<!-- -------------------------------------------------------------- -->
		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>


	</body>
</html>