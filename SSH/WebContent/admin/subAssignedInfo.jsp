<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理已分配信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignedInfo.js"></script>
		
		<br>
		<table width="100%">
			<tr>
				<td>
					<font SIZE="+1" COLOR="#ff6600">已分配的学生及其课题信息：</font>
				</td>

				<td>
					<a href="admin/subAssignedInfo!Excel.action?printable=true">点此导出Excel</a> 
					<br>
					<br>
				</td>
			</tr>
		</table>

		<FONT COLOR="slategray">注意：若学生的课题为空，表示原本分配的课题已被删除。若课题属性为空，表示此课题未注册。</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="45" ALIGN="center" class="tableTop">
					序号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					学号
				</TD>
				<TD width="95" ALIGN="center" class="tableTop">
					姓名
				</TD>
				<TD width="300" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					课题类型
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					课题性质
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					承担方式
				</TD>
				<TD width="85" ALIGN="center" class="tableTop">
					删除
				</TD>
			</TR>
			
			<s:iterator value="students" var="student" status="st">
			<tr bgcolor="#dcdcdc">
			
			<td align="center" class="tableDetail">${st.count+(page-1)*10}</td>
			<td align="center" class="tableDetail"><s:property value="studentno"/></td>
			<td align="center" class="tableDetail"><s:property value="name"/></td>
			
			<td align="center" class="tableDetail"><s:property value="thesis.name"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.teacher.name"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.type"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.property"/></td>
			<td align="center" class="tableDetail"><s:property value="thesis.mode"/></td>
			<td align="center" class="tableDetail">
			<a HREF="admin/subAssignedDel!query.action?studentNo=${student.studentno}">删除</a>
				</td>
			</tr>
			</s:iterator>



		</TABLE>
		<div>
			第
			<span id="page">${page}</span>页，共
			<span id="totalPage">${totalPage}</span>页
			<a id="pre"
				href="admin/subAssignedInfo.action?page=${page-1}">上一页</a>
			，
			<a id="next"
				href="admin/subAssignedInfo.action?page=${page+1}">下一页</a>
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