<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-查询模板评语</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/pyQuery.js"></script>
		<br>
		
		<!-- -------------------------------------------------------------- -->


	
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>

				<TD width="95" ALIGN="center" class="tableTop">
					评语等级
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					评阅评语
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					指导评语
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					答辩评语
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					修改评语
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					删除评语
				</TD>
			</TR>

			<s:iterator value="pys" var="py" status="st2">
				<tr class="tableDetail">
					<td class="tableDetail" align="center">
						<s:property value="lv" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="pypingyu" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="zdpingyu" />
					</td>
					<td class="tableDetail" align="center">
						<s:property value="dbpingyu" />
					</td>
					<td class="tableDetail" align="center">
						<A HREF="admin/pyModify!modify.action?pyNo=${py.pyno}">修改</A>
					</td>
					<td class="tableDetail" align="center">
						<A HREF="admin/pyDel.action?pyNo=${py.pyno}">删除</A>
					</td>
					</tr>
			</s:iterator>
		</TABLE>
		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre"
				href="admin/pyQuery!query.action?page=${page-1}">上一页</a>
			，
			<a id="next"
				href="admin/pyQuery!query.action?page=${page+1}">下一页</a>
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