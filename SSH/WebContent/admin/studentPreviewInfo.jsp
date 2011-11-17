<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生预选信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/studentPreviewInfo.js"></script>
		
		<br>
		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">所有学生的课题预选信息：</font>
				</td>

				<td>
					<a href="admin/studentPreviewInfo!Excel.action?printable=true">点此导出Excel</a>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<!-- -------------------------------------------------------------- -->


		<FONT COLOR="slategray">注意：这是所有学生的课题预选信息，若有学生还没有选择课题，将显示一条只有学号和姓名的信息。</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>

				<TD width="95" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					志愿顺序
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					预选课题
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学生详细信息
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					课题详细信息
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					删除
				</TD>
			</TR>

			<s:iterator value="previews" var="preview" status="st2">
				<tr class="tableDetail">
					<td class="tableDetail" align="center">
						<s:property value="student.studentno" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="student.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="suborder" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.name" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="thesis.teacher.name" />
					</td>
					<td class="tableDetail" align="center">
						<A HREF="admin/studentPreviewInfo!studentDetail.action?studentNo=${preview.student.studentno}">查看</A>
					</td>
					<td class="tableDetail" align="center">
						<A HREF="admin/studentPreviewInfo!thesisDetail.action?thesisNo=${preview.thesis.thesisno}">查看</A>
					</td>
					<td class="tableDetail" align="center">
						<A HREF="admin/studentPreviewInfo!delete.action?previewNo=${preview.previewno}">删除</A>
					</td>
					</tr>
			</s:iterator>


		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre"
				href="admin/studentPreviewInfo!query.action?page=${page-1}">上一页</a>
			，
			<a id="next"
				href="admin/studentPreviewInfo!query.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>


		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>


	</body>
</html>