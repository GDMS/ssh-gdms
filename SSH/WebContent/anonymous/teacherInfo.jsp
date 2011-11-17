<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>指导教师联系方式</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="anonymous/teacherInfo.js"></script>
		<br>
		<!-- -------------------------------------------------------------- -->


		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">指导教师联系方式：</font>
				</td>

				<td>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="95" ALIGN="center" class="tableTop">
					教师姓名
				</TD>
				<TD width="135" ALIGN="center" class="tableTop">
					所属系别
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					电话号码
				</TD>
				<TD width="215" ALIGN="center" class="tableTop">
					E-mail
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="teachers" var="teacher" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="name" />
						</td>
						<td align="center">
							<s:property value="teacherDept.name" />
						</td>
						<td align="center">
							<s:property value="tel" />
						</td>
						<td align="center">
							<s:property value="mail" />
						</td>
					</tr>
				</s:iterator>
			</tr>
		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="anonymous/teacherInfo.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="anonymous/teacherInfo.action?page=${page+1}">下一页</a>
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