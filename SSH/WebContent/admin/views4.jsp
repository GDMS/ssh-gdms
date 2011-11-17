<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员查看视图-教师指导学生数</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/views4.js"></script>
		
		<br>
		<!-- -------------------------------------------------------------- -->


		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">教师指导学生数：</font>
				</td>

				<td>
					<a href="admin/views4!Excel.action?printable=true">点此导出Excel</a> 
					<br>
					<br>
				</td>
			</tr>
		</table>
		<table CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<tr>
				<td width="115" ALIGN="center" class="tableHeading">
					教师
				</td>
				<td width="135" ALIGN="center" class="tableHeading">
					计划人数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					课题数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					实际人数
				</td>
				<td width="115" ALIGN="center" class="tableHeading">
					差额
				</td>

			</tr>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="views4s" var="all" status="st2">
					<tr class="tableDetail">
						<td align="center">
							<s:property value="tutor" />
						</td>
						<td align="center">
							<s:property value="plannum" />
						</td>
						<td align="center">
							<s:property value="subnum" />
						</td>
						<td align="center">
							<s:property value="actualnum" />
						</td>
						<td align="center">
							<s:property value="dif" />
						</td>
					</tr>
				</s:iterator>
			</tr>
		</TABLE>

		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/views4!query.action?page=${page-1}">上一页</a> ，
			<a id="next" href="admin/views4!query.action?page=${page+1}">下一页</a>
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