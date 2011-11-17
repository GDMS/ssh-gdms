<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员查看视图-差生预选情况</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
<script type="text/javascript" src="admin/views2.js"></script>
		
		<br>
		<!-- -------------------------------------------------------------- -->


		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">差生预选情况：</font>
				</td>

				<td>
						<a href="admin/views2!Excel.action?printable=true">点此导出Excel</a> 
					<br>
					<br>
				</td>
			</tr>
		</table>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="115" ALIGN="center" class="tableHeading">
					姓名
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					学分绩点
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					导师
				</TD>
				<TD width="135" ALIGN="center" class="tableHeading">
					预选老师
				</TD>
				<TD width="115" ALIGN="center" class="tableHeading">
					课题名称
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="views2s" var="all" status="st2">
					<tr class="tableDetail">
				<td align="center">
							<s:property value="sname" />
						</td>
				<td align="center">
							<s:property value="credit" />
						</td>
				<td align="center">
							<s:property value="tutor" />
						</td>
				<td align="center">
							<s:property value="expr" />
						</td>
				<td align="center">
							<s:property value="subname" />
						</td>
			</tr>
				</s:iterator>
			</tr>


		</TABLE>
		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre" href="admin/views2!query.action?page=${page-1}">上一页</a>
			，
			<a id="next" href="admin/views2!query.action?page=${page+1}">下一页</a>
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