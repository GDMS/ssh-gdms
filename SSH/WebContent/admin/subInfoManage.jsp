<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理课题信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
		
	</head>

	<body>
	<script type="text/javascript" src="/admin/excel.js"></script>
		
		<br>

		<!-- -------------------------------------------------------------- -->


		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">已注册的课题信息：</font>
				</td>

				<td>
					<a href="admin/subInfoManage!Excel.action?printable=true">点此导出Excel</a>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="300" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					题目类型
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					题目性质
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					承担方式
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					分配情况
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					已被预选次数
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					删除
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<s:iterator value="thesises" var="thesis" status="st2">
				<tr class="tableDetail">
					
					<td align="center">
						<s:property value="name" />
					</td>
					<td align="center">
						<s:property value="teacher.name" />
					</td>
					<td align="center">
						<s:property value="type" />
					</td>
					<td align="center">
						<s:property value="property" />
					</td>
					<td align="center">
						<s:property value="mode" />
					</td>
					<td align="center">
					<s:if test="assigned!=null">
					<s:property value="assigned" />
					</s:if>
					<s:else>未分配
					</s:else>
					</td>
					<td align="center">
						<s:property value="%{num[#st2.index]}" />
					</td>
					<td align="center">
						<A HREF="admin/subInfoManage!delete.action?thesisno=${thesis.thesisno}">删除</A>
					</td>
					</tr>
			</s:iterator>
			</tr>


		</TABLE>
		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre"
				href="admin/subInfoManage!query.action?page=${page-1}">上一页</a>
			，
			<a id="next"
				href="admin/subInfoManage!query.action?page=${page+1}">下一页</a>
			转到：第
			<input type=text id="pageNo" size=1 value="${page}">
			页
			<input type=button id="go" value=GO onclick="gotoPage(${totalPage})">
		</div>



		<!-- -------------------------------------------------------------- -->


		<p><A HREF="admin/main.jsp">返回</A></p>


	</body>
</html>