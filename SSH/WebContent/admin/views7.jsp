<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-学生毕业设计成绩信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/views7.js"></script>
		
		<br>
		<!-- -------------------------------------------------------------- -->

		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">学生毕业设计成绩信息：</font>
				</td>

				<td>
					<a href="admin/views7!Excel.action?printable=true">点此导出Excel</a> 
					<br>
					<br>
				</td>
			</tr>
		</table>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="115" ALIGN="center" class="tableHeading">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					姓名
				</TD>
				<TD width="65" ALIGN="center" class="tableHeading">
					性别
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					专业
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					班级
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					导师
				</TD>
				<TD width="175" ALIGN="center" class="tableHeading">
					课题
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					毕设成绩
				</TD>
				<TD width="95" ALIGN="center" class="tableHeading">
					学分绩点
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					联系方式
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					Email
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="views7s" var="all" status="st2">
					<tr class="tableDetail">
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
			</tr>
		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/views7!query.action?page=${page-1}">上一页</a> ，
			<a id="next" href="admin/views7!query.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>

		<center>
			<A HREF="admin/viewSelect.jsp">返回</A>
		</center>


	</body>
</html>