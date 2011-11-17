<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理教师信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/teacherInfo.js"></script>
		<br>
		<!-- -------------------------------------------------------------- -->


		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">已注册的教师信息：</font>
				</td>

				<td>
					<a href="admin/teacherInfo!Excel.action?printable=true">点此导出Excel</a>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<FONT COLOR=slategray>注意：删除教师之前先要把该教师的所有课题删除。</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="95" ALIGN="center" class="tableTop">
					教师工号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					教师姓名
				</TD>
				<TD width="135" ALIGN="center" class="tableTop">
					密码
				</TD>
				<TD width="135" ALIGN="center" class="tableTop">
					所属系别
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					可指导学生数
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					已指导学生数
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					电话号码
				</TD>
				<TD width="215" ALIGN="center" class="tableTop">
					E-mail
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					查看注册课题
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					修改
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					删除
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="teachers" var="teacher" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="teacherno" />
						</td>
						<td align="center">
							<s:property value="name" />
						</td>
						<td align="center">
							<s:property value="password" />
						</td>
						<td align="center">
							<s:property value="teacherDept.name" />
						</td>
						<td align="center">
							<s:property value="subnum" />
						</td>
						<td align="center">
							<s:property value="%{num[#st2.index]}" />

						</td>
						<td align="center">
							<s:property value="tel" />
						</td>
						<td align="center">
							<s:property value="mail" />
						</td>

						<td align="center">
							<A
								HREF="admin/teacherInfo!ans.action?teacherno=${teacher.teacherno}">查看</A>
						</td>
						<td align="center">
							<A
								HREF="admin/teacherInfoMod!query.action?teacherno=${teacher.teacherno}">修改</A>
						</td>
						<td align="center">
							<A
								HREF="admin/teacherInfo!delete.action?teacherno=${teacher.teacherno}">删除</A>
						</td>
					</tr>
				</s:iterator>
			</tr>
		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/teacherInfo!query.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="admin/teacherInfo!query.action?page=${page+1}">下一页</a>
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